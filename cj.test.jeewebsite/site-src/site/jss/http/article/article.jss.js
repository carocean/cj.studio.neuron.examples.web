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

var String = Java.type('java.lang.String');
var WebUtil = Java.type('cj.studio.ecm.net.web.WebUtil');
var SimpleDateFormat = Java.type('java.text.SimpleDateFormat');
var Date = Java.type('java.util.Date');
var Long = Java.type('java.lang.Long');
var CircuitException=Java.type('cj.studio.ecm.graph.CircuitException');

exports.flow = function(req,resp,ctx) {
	var doc = ctx.html("/article/article.html", "utf-8");
	var articleBS=imports.head.services.articleBS;
	printCatsOnTools(articleBS,doc);
	printCats(articleBS,doc);
	var category=req.getParameter('category');
	var printer=chip.site().getService('$.cj.jss.http.article.printArticle');
	if(category==''||category==null||category=='undefined'){
		var list=articleBS.getAllArticles();
		printer.printArticleList(list,doc);
		resp.getWriter().write(doc.toString());
	}else{
		var list;
		if(category==-1){
			list=articleBS.getAllArticles();
		}else{
			list=articleBS.getArticlesByCategory(category);
		}
		printer.printArticleList(list,doc);
		resp.getWriter().write(doc.select('.table').html());
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
