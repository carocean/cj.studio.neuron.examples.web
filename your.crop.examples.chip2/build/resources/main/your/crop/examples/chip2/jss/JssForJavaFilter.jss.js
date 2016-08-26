/*
 * 
 * 作者：cj
 * 说明：
 * filter使用它需要在assembly.json中开启过滤器模式switchFilter:"on"，它用于拦截java服务的方法，即此机制实现了以jss代理java的功能
 * 由于filter拦截服务请求链路，因此影响性能，一般情况不建议使用服务过滤机制.switchFilter:"off"
 * <![jss:{
		scope:'runtime',
		extends:'',
		isStronglyJss:false,
		filter:{
			invalid:'false',
			pattern:'myAnnoService',
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

var String = Java.type('java.lang.String');

exports.doFilter=function(proxy,method,args){
	print('-------++++++这是jss中拦截java服务的方法：'+method);
	return method.invoke(proxy,args[0],args[1]);
}
