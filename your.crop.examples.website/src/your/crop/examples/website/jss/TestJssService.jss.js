/*
 * 作者：演示一般服务
 * 说明：
 * extends可以实现一种类型，此类型将可在java中通过调用服务提供器的.getServices(type)获取到。这样在java代码中直接使用接口间接的调用到jss实现
 * 注意使用extends的限制：
 * 1.jss必须实现该接口的方法，而且一定是导出方法，即声明为exports.method=function格式
 * 如果未有正确实现extends接口方法，则返回为null
 * extends的调用参考RefJssService类中的用例
 * isStronglyJss:true 表示该jss服务使用强jss类型对象，必须指定extends派生接口，这在以注入方式引用jss服务时非常有用，默认是弱类型，即返回ScriptObjectMirror类型
 * filter使用它需要在assembly.json中开启过滤器模式，它用于拦截java服务的方法，即此机制实现了以jss代理java的功能
 * 
 * 缺陷：java8 nashorn 在jdk8 65u之后的版本存在缺陷65u正常
 * 描述：绑定域可见性缺陷，比如一个jss服务的imports域，在非函数代码中可以打印出来，在函数（如：exports.test=function())代码段内却报imports未定义异常。
 * ScriptContext.ENGINE_SCOPE
 * 老外分析：jdk8 102版也存在此问题，95版也存在
 * http://stackoverflow.com/questions/37611959/java-8-passing-a-function-through-bindings
 * <![jss:{
		scope:'runtime',
		extends:'cj.studio.ecm.net.web.IHttpFilter',
		filter:{
			invalid:'false',
			pattern:'simpleService',
			interrupter:'doFilter'
	 	}
 	},
 	shit:{
 		name:"fuck"
 	}
 ]>
 <![desc:{
	ttt:'2323',
	obj:{
		name:'09skdkdk'
		}
* }]>
*/
var String=Java.type('java.lang.String');

//java拦截实现
exports.doFilter=function(proxy,method,args){
	//如果想拦截java服务simpleService方法请先确认本jss文件头的filter.invalid=false,且Assembly.json中配置的jss模块test的过滤器模式：switchFilter:"on"
	print('-------++++++这是jss中拦截java服务的方法：'+method);
	return method.invoke(proxy,args);
}
//IHttpFilter实现
exports.sort=function(){
	return 0;
}
//IHttpFilter实现
exports.flow=function(frame,circuit, plug){
	//这是一般的web过滤器
	print('这是由jss实现的http过滤器的拦截:'+frame)
	plug.flow(frame,circuit);
}
exports.printEcho=function(text){
	print(text);
}