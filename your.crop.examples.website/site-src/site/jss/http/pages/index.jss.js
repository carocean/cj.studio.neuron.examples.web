//全局隐含一个page对象
this.name = 'zzzzz';
print('index.jss.js');
exports.doPage = function(frame,circuit, plug, ctx) {
	print('这是首页啊2')
	var engine = ctx.resourceText('/js/cj.engine.js');
	var doc = ctx.html(frame.relativePath());
	var head = doc.getElementsByTag("head");
	var wsscript = ctx.resourceText('/js/dows.js');
	head.append("<script>"+engine+" "+wsscript+" </script>");
	var ws = doc.getElementById("init");
	var url="ws://"+frame.head("Host")+"' +r+ '"+"/wssite";
	ws.attr("onclick","var r=getWebRootPath();openit('"+url+"');");
	var send = doc.getElementById("send");
	send.attr("onclick","sendit();");
	circuit.content().writeBytes(doc.toString().getBytes());
	var s = plug.site().getService('refJssService3');
	var ret = s.cal(10, 100);
	print("******" + ret);
	// print('重定向到/pages/2.html');
	// ctx.redirect('/pages/2.html',frame,plug);
	var httpFilter = Java.type('cj.studio.ecm.net.web.IHttpFilter');
	var col = plug.site().getServices(httpFilter.class);
	print('这是获取到的httpFilter服务数：' + col.size());
}