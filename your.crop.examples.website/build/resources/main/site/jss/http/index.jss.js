//var imports = new JavaImporter(java.io, java.lang);
//with (imports) {  
//  var file = new File(__FILE__);  //查找我在哪里？
//  System.out.println('哪里: ' + file.getAbsolutePath());   //内容比较古怪
  // /path/to/my/script.js
//}
//全局隐含一个page对象
this.name='zzzzz';
print('index.jss.js');
exports.doPage=function(frame,circuit,plug,ctx){
	circuit.attribute("aaa","jss put");
	var doc=ctx.html('/pages/index.html',"utf-8");
	var tnt = doc.getElementById("button1");
	var text = doc.getElementById("test");
    var head = doc.getElementsByTag("head");
	text.html('<div>fuck!</div>');
    head.append("<script>function dotest(){alert(document.getElementById('test').innerHTML);document.getElementById('test').innerHTML='吊吊';}</script>");
	tnt.attr("onclick","dotest();");
	circuit.content().writeBytes(doc.toString().getBytes());
	print('jss dopage...');
	var Page=Java.type('cj.test.website.HomePage');
	var p=new Page();
    print(chip.site());
   var obj= chip.site().getService('$.cj.jss.services1.dept.Test');
   print('this is $.cj.jss.services1.dept.Test:'+obj);
   print('---------------');
   print('module_name:' + imports.module_name);
   print('module_home:' + imports.module_home);
   print('module_ext:' + imports.module_extName);
   print('module_pack:' + imports.module_package);
   print('module_unzip:' + imports.module_unzip);
   print('module_type:' + imports.module_type);
  // print('head jss scope:'+imports.head.jss.scope);
  // print('head shit name:'+imports.head.shit.name);
   print('location:' + imports.locaction);
   print('source:' + imports.source);
   print('selectKey1:' + imports.selectKey1);
   print('selectKey2:' + imports.selectKey2);
   print('this is jss chip site ' + chip.site());
   obj.doPage('tytytytty');
   // print(plug.session().sessionId());
}