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
var ArticleBO=Java.type('cj.test.jeewebpart.bo.ArticleBO');
var BigInteger=Java.type('java.math.BigInteger');
var URLDecoder=Java.type('java.net.URLDecoder');

exports.flow = function(req,resp,ctx) {
	var articleBS=imports.head.services.articleBS;
	var bo=new ArticleBO();
	bo.cnt=req.getParameter('cnt');
	bo.title=req.getParameter('title');
	bo.creator=req.getParameter('creator');
	bo.category=BigInteger.valueOf(req.getParameter('category'));
	articleBS.saveArticle(bo);
	//以下返回文章列表的json数据
	var doc = ctx.html("/article/article.html", "utf-8");
	var printer=chip.site().getService('$.cj.jss.http.article.printArticle');
	var list=articleBS.getAllArticles();
	printer.printArticleList(list,doc);
	resp.getWriter().write(doc.select('.table').html());
	
}
