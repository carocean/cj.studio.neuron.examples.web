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
var BigInteger=Java.type('java.math.BigInteger');
var CircuitException=Java.type('cj.studio.ecm.graph.CircuitException');
var SimpleDateFormat = Java.type('java.text.SimpleDateFormat');
var Date = Java.type('java.util.Date');
var Long = Java.type('java.lang.Long');

exports.doPage = function(frame, circuit, plug, ctx) {
	var doc = ctx.html("/article/articleview.html", "utf-8");
	var articleBS=imports.head.services.articleBS;
	var id=frame.parameter('article');
	if(id==null||id==''||id=='undefined'){
		throw new CircuitException('503','未指定文章');
	}
	var art=articleBS.getArticle(new BigInteger(id));
	if(art==null){
		throw new CircuitException('404','文章不存在');
	}
	var cat=articleBS.getCategory(art.category);
	printArticle(art,cat,doc);
	circuit.content().writeBytes(doc.toString().getBytes());
}
function printArticle(art,cat,doc){
	doc.select('.panel > ul > li[title]').append(art.title);
	var format=  new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
	var date=new Date(Long.valueOf(art.ctime));
	var ctime=format.format(date);
	doc.select('.panel > ul > li[ctime]').append(ctime);
	doc.select('.panel > ul > li[cnt]').append(art.cnt);
	doc.select('.panel > ul > li[creator]').append(art.creator);
	doc.select('.panel > ul > li[category]').append(cat.name);
}