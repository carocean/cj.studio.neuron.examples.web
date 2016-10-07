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

exports.doPage = function(frame, circuit, plug, ctx) {

	var doc = ctx.html("/article/article.html", "utf-8");
	var articleBS=imports.head.services.articleBS;
	printArticleList(articleBS,doc);
	circuit.content().writeBytes(doc.toString().getBytes());
}
function printArticleList(articleBS,doc){
	var list=articleBS.getAllArticles();
	var ul=doc.select('.rows').first();
	var cli=ul.select('>li.row').first().clone();
	ul.select('>li.row').remove();
	for(var i=0;i<list.size();i++){
		var art=list.get(i);
		var li=cli.clone();
		li.select('.columns>li[title]>span').html(art.title);
		li.select('.columns>li[creator]>span').html(art.creator);
		li.select('.columns>li[ctime]>span').html(art.ctime);
		ul.append(li);
	}
}