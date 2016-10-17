/*
 * 2016.0829
 * 作者：赵向彬
 * 说明：services是声明本jss要引用的服务
 * <![jss:{
		scope:'runtime',
		extends:'cj.studio.ecm.net.jee.IJeeWebView',
		isStronglyJss:true,
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

exports.flow = function(req,resp,resource) {
	print('formx')
}