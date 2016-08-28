/*
 * 2016.0829
 * 作者：赵向彬
 * 说明：extends可以实现一种类型，此类型将可在java中通过调用服务提供器的.getServices(type)获取到。这样在java代码中直接使用接口间接的调用到jss实现
 * 注意使用extends的限制：
 * 1.jss必须实现该接口的方法，而且一定是导出方法，即声明为exports.method=function格式
 * 	isStronglyJss:true 表示该jss服务使用强jss类型对象，必须指定extends派生接口，这在以注入方式引用jss服务时非常有用，默认是弱类型，即返回ScriptObjectMirror类型
 * 2.filter使用它需要在assembly.json中开启过滤器模式，它用于拦截java服务的方法，即此机制实现了以jss代理java的功能
 * 
 * 缺陷：java8 nashorn 在jdk8 65u之后的版本存在缺陷65u正常
 * 描述：绑定域可见性缺陷，比如一个jss服务的imports域，在非函数代码中可以打印出来，在函数（如：exports.test=function())代码段内却报imports未定义异常。
 * ScriptContext.ENGINE_SCOPE
 * 老外分析：jdk8 102版也存在此问题，95版也存在
 * http://stackoverflow.com/questions/37611959/java-8-passing-a-function-through-bindings
 * <![jss:{
		scope:'runtime',
		extends:'',
		filter:{
	 	}
 	},
 	shit:{
 		name:"fuck"
 	}
 ]>
*/

//var imports = new JavaImporter(java.io, java.lang);
//with (imports) {  
//  var file = new File(__FILE__);  //查找我在哪里？
//  System.out.println('哪里: ' + file.getAbsolutePath());   //内容比较古怪
  // /path/to/my/script.js
//}
var FormData = Java.type('cj.studio.ecm.frame.FormData');
var String = Java.type('java.lang.String');
var WebUtil=Java.type('cj.studio.ecm.net.web.WebUtil');

exports.doPage = function(frame,circuit, plug, ctx) {
	print('Content-Type:'+frame.contentType());
	var data = frame.content().readFully();
	var params=WebUtil.parserParam(new String(data));
	print(params);
	
	var doc = ctx.html("/pages/response.html", "utf-8");
	//使用类似jquery的语法来为dom fu zhi，我操他妈哩个比的汉字，打字这么难。
	doc.select('.response>span[name]').html(params.name);
	doc.select('.response>span[age]').html(params.age);
	
	var session=frame.session();
	print('------会话实例：'+session);
	
	 print('------打印jss服务的导入属性和所在芯片信息---------');
	   print('module_name:' + imports.module_name);
	   print('module_home:' + imports.module_home);
	   print('module_ext:' + imports.module_extName);
	   print('module_pack:' + imports.module_package);
	   print('module_unzip:' + imports.module_unzip);
	   print('module_type:' + imports.module_type);
	   print('head jss scope:'+imports.head.jss.scope);
	   print('head shit name:'+imports.head.shit.name);
	   print('location:' + imports.locaction);
	   print('source:' + imports.source);
	   print('selectKey1:' + imports.selectKey1);
	   print('selectKey2:' + imports.selectKey2);
	   print('this is jss chip site ' + chip.site());
	   print('---------');
	   
	circuit.content().writeBytes(doc.toString().getBytes());
}