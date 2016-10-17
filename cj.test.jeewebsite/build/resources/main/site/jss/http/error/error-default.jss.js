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
 		articleBS:"articleBS"
 	}
 ]>
 */
exports.flow = function(req,resp,ctx) {
	print('默认错误处理')
	var doc=ctx.html(req.relativeUrl());
	var code=doc.getElementById('code');
	var msg=doc.getElementById('msg');
	var cause=doc.getElementById('cause');
	var c=resp;
	code.html(c.errorCode());
	msg.html(c.errorMessage());
	cause.html(c.errorCause());
	resp.getWriter().write(doc.toString());
}