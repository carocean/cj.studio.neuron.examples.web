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
var SimpleDateFormat = Java.type('java.text.SimpleDateFormat');
var Date = Java.type('java.util.Date');
var Long = Java.type('java.lang.Long');

exports.doPage = function(frame, circuit, plug, ctx) {
	
	var doc = ctx.html("/article/article.html", "utf-8");
	var articleBS=imports.head.services.articleBS;
	printCatsOnTools(articleBS,doc);
	printCats(articleBS,doc);
	var category=frame.parameter('category');
	if(category==''||category==null||category=='undefined'){
		var list=articleBS.getAllArticles();
		exports.printArticleList(list,doc);
		circuit.content().writeBytes(doc.toString().getBytes());
	}else{
		var list;
		if(category==-1){
			list=articleBS.getAllArticles();
		}else{
			list=articleBS.getArticlesByCategory(category);
		}
		exports.printArticleList(list,doc);
		circuit.content().writeBytes(doc.select('.table').html().getBytes());
	}
	
}
function printCats(articleBS,doc){
	var cats=articleBS.getCategories();
	var select=doc.select('.panel > ul > li[category]>select').first();
	var copt=select.select('>option').first().clone();
	select.empty();
	for(var i=0;i<cats.size();i++){
		var cat=cats.get(i);
		var opt=copt.clone();
		opt.attr('value',cat.id+'');
		opt.html(cat.name);
		select.append(opt);
	}
}
function printCatsOnTools(articleBS,doc){
	var cats=articleBS.getCategories();
	var select=doc.select('.tools > ul > li[categories]>select').first();
	var copt=select.select('>option').first().clone();
	select.empty();
	for(var i=0;i<cats.size();i++){
		var cat=cats.get(i);
		var opt=copt.clone();
		opt.attr('value',cat.id+'');
		opt.html(cat.name);
		select.append(opt);
	}
	var opt=copt.clone();
	opt.attr('value','-1');
	opt.html('所有分类');
	opt.attr('selected','selected');
	select.prepend(opt);
}
//导出该函数，因为createarticle.jss.js服务要用到
exports.printArticleList=function(list,doc){
	var ul=doc.select('.rows').first();
	var cli=ul.select('>li.row').first().clone();
	ul.select('>li.row').remove();
	var format=  new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
	for(var i=0;i<list.size();i++){
		var art=list.get(i);
		var li=cli.clone();
		li.select('.columns>li[title]>span').html(art.title);
		li.select('.columns>li[creator]>span').html(art.creator);
		var date=new Date(Long.valueOf(art.ctime));
		var ctime=format.format(date);
		li.select('.columns>li[ctime]>span').html(ctime);
		li.attr('id',art.id+'');
		ul.append(li);
	}
}