/*
 * 说明：
 * 作者：extends可以实现一种类型，此类型将可在java中通过调用服务提供器的.getServices(type)获取到。
 * <![jss:{
		scope:'runtime',
		extends:'cj.studio.ecm.web.IHttpFilter',
		filter:{
			invalid:'false',
			pattern:'refJssService3',
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

print('---------------');
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
var info = chip.info();
print(info.id);
print(info.name);
print(info.version);
print(info.getProperty('home.dir'));
print('-----------------end.')
exports.doFilter=function(proxy,method,args){
	print('-------++++++这是jss中拦截java服务的方法：'+method);
	return proxy.cal(args[0],args[1]);
}
exports.doPage=function(str){
	print("by call do test.page:"+str);
}
exports.sort=function(){
	return 2;
}
exports.flow=function(frame,circuit, plug){
	print('this is implement IHTTPFilter.it get by serviceType')
	plug.flow(frame,circuit);
}