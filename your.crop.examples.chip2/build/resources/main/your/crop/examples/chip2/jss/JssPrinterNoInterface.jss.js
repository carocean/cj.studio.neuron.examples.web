/*
 * 
 * 作者：
 * 说明：
 * isStronglyJss:false 指成弱接口，则此jss服务即可按接口调用也可按无接口调用，本文演示无接口的，可以将extends设空或不要
 * <![jss:{
		scope:'runtime',
		extends:'your.crop.examples.chip2.jss.ITestJss',
		isStronglyJss:false
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

exports.doit=function(text){
	print('--selectKey1:' + imports.selectKey1);
	print('--selectKey2:' + imports.selectKey2);
	print('hello world jss '+text);
	test(text);
}
function test(text){
	var site=chip.site();
	//jss服务互调
	var printer=site.getService('$.cj.jss.test.JssPrinter');
	printer.printHello('0000000'+text);
}
