/*
 * 2016.0829
 * 作者：赵向彬
 * 说明：services是声明本jss要引用的服务
 * <![jss:{
		scope:'runtime',
		extends:'',
		isStronglyJss:false,
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