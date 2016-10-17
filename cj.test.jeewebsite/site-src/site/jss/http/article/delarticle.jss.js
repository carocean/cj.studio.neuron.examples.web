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

var FormData = Java.type('cj.studio.ecm.frame.FormData');
var String = Java.type('java.lang.String');
var WebUtil = Java.type('cj.studio.ecm.net.web.WebUtil');
var ArticleBO=Java.type('cj.test.jeewebsite.bo.ArticleBO');
var BigInteger=Java.type('java.math.BigInteger');
var URLDecoder=Java.type('java.net.URLDecoder');

exports.flow = function(req,resp,ctx) {
	var articleBS=imports.head.services.articleBS;
	var id=req.getParameter('id');
	articleBS.deleteArticle(BigInteger.valueOf(id));
}
