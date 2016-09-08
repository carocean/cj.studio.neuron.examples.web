/*
 * 2016.0829
 * 作者：赵向彬
 * 说明：services是声明本jss要引用的服务
 * <![jss:{
		scope:'runtime',
		extends:'',
		filter:{
	 	}
 	},
 	services:{
 		userDao:"userDao",
 		jssUserDao:"$.cj.jss.test.UserDao"
 	}
 ]>
 */

var FormData = Java.type('cj.studio.ecm.frame.FormData');
var String = Java.type('java.lang.String');
var WebUtil = Java.type('cj.studio.ecm.net.web.WebUtil');

exports.doPage = function(frame, circuit, plug, ctx) {
	print('Content-Type:' + frame.contentType());
	var data = frame.content().readFully();
	var params = WebUtil.parserParam(new String(data));
	print(params);

	var doc = ctx.html("/pages/response.html", "utf-8");
	// 使用类似jquery的语法来为dom fu zhi
	doc.select('.response>span[name]').html(params.name);
	doc.select('.response>span[age]').html(params.age);

	var session = frame.session();
	print('------会话实例：' + session);

	print('------打印jss服务的导入属性和所在芯片信息---------');
	print('module_name:' + imports.module_name);
	print('module_home:' + imports.module_home);
	print('module_ext:' + imports.module_extName);
	print('module_pack:' + imports.module_package);
	print('module_unzip:' + imports.module_unzip);
	print('module_type:' + imports.module_type);
	print('head jss scope:' + imports.head.jss.scope);
	print('location:' + imports.locaction);
	print('source:' + imports.source);
	print('selectKey1:' + imports.selectKey1);
	print('selectKey2:' + imports.selectKey2);
	print('this is jss chip site ' + chip.site());
	print('---------');
	// 由三种方式获取服务：
	// 1.通过头注入
	print('这是采用jss头注入的服务：' + imports.head.services.userDao);
	print('这是采用jss头注入的服务：' + imports.head.services.jssUserDao);
	var users=imports.head.services.jssUserDao.getUsers();
	for (var i = 0; i < users.size(); i++) {
		print('演示在jss中访问数据库:' + users.get(i));
	}
	// 2.通用的获取方法是：chip.site();
	var site = chip.site();
	print('这是通过chip站点获取服务' + site.getService('userDao'));
	// 3.如果是页面，可通过plug.site()获取
	// var site=plug.site();
	// var userDao=site.getService('userDao');
	// var users=userDao.getUsers();
	// for(var i=0;i<users.size();i++){
	// print('演示在jss中访问数据库:'+users.get(i));
	// }
	circuit.content().writeBytes(doc.toString().getBytes());
}