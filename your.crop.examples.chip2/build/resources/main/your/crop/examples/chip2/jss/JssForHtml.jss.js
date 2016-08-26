/*
 * 
 * 作者：cj
 * 说明：
 * filter使用它需要在assembly.json中开启过滤器模式switchFilter:"on"，它用于拦截java服务的方法，即此机制实现了以jss代理java的功能
 * 由于filter拦截服务请求链路，因此影响性能，一般情况不建议使用服务过滤机制.switchFilter:"off"
 * <![jss:{
		scope:'runtime',
		extends:'your.crop.examples.chip2.jss.IJssPage',
		isStronglyJss:true
 	},
 	shit:{
 		name:"fuck"
 	}
 ]>
 <![desc:{
	ttt:'2323',
	obj:{
		name:'09skdkdk'
		}
* }]>
*/

var String = Java.type('java.lang.String');
var Jsoup = Java.type('org.jsoup.Jsoup');
var FileHelper=Java.type('cj.ultimate.util.FileHelper');
var File = Java.type('java.io.File');

exports.doPage=function(frame,circuit){
	print('-----演示用ecm处理html文档，请把jsp,struts,spring mvc 连同j2ee也扔了吧，过时了。请求：'+frame);
	//不论是websitegraph,cvcGraph还是webmodulegraph，在使用jss对网页的处理上基本上和本例是一致的
	var path=imports.module_home+File.separator+'testhtml.html';
	var file=new File(path);
	print('-----处理html前的内容');
	var html=new String(FileHelper.readFully(file));
	var doc = Jsoup.parse(html, 'utf-8');
	print(doc);
	doc.select('.v1').attr('value','fuck you!');
	doc.select('.v2').attr('value','fuck you too');
	doc.select('.l1').html('哈哈');
	circuit.content().writeBytes(doc.toString().getBytes());
}
