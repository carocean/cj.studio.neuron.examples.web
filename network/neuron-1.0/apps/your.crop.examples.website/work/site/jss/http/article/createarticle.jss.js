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
 		articleBS:"articleBS"
 	}
 ]>
 */

var FormData = Java.type('cj.studio.ecm.frame.FormData');
var String = Java.type('java.lang.String');
var WebUtil = Java.type('cj.studio.ecm.net.web.WebUtil');
var ArticleBO=Java.type('your.crop.examples.website.bo.ArticleBO');
var BigInteger=Java.type('java.math.BigInteger');
var URLDecoder=Java.type('java.net.URLDecoder');

exports.doPage = function(frame, circuit, plug, ctx) {
	var articleBS=imports.head.services.articleBS;
	var data = frame.content().readFully();
	var params=WebUtil.parserParam(new String(data));
	print(params);
	var bo=new ArticleBO();
	bo.cnt=params.cnt;
	bo.title=params.title;
	bo.creator=params.creator;
	bo.category=BigInteger.valueOf(params.category);
	articleBS.saveArticle(bo);
	//以下返回文章列表的json数据
	var doc = ctx.html("/article/article.html", "utf-8");
	var articleView=plug.site().getService('$.cj.jss.http.article.article');
	var list=articleBS.getAllArticles();
	articleView.printArticleList(list,doc);
	circuit.content().writeBytes(doc.select('.table').html().getBytes());
	
}
