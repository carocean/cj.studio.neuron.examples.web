/*
 * 
 * 作者：cj
 * 说明：
 * 使用jss方面来拦java服务的桥
 * 
 * <![jss:{
		scope:'runtime',
		extends:'cj.studio.ecm.bridge.IAspect',
		isStronglyJss:true
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

exports.cut=function(bridge, args,point){
	print('*****这是jss方面:'+String.format("－－－方面拦截执行方法：%s.%s%s",point.getServiceDefId(),point.getMethodName(),point.getMethodDesc()));
	return point.cut(bridge, args);
}
exports.getCutInterfaces=function(){
	return null;
}
