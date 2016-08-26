本例程源自：http://www.cjlns.com
cjlns.com平台，是以面向连接编程实现的，从架构到部署均采用了连接体系。

 《面向连接编程》http://www.cjlns.com/portlets/center/portlet-00001-show/views/ecm.html
 
	面向连接编程是一个完整的工具体系,从web的mvc到存储层，从开发工具到分布式部署，一套完整的开发和工具体系，从而可以使用户摆脱那种拼拼补补的开发现状。
面向连接的工具体系的优势在于，在架构层面，比spring更简单易用，比osgi更省事，比nodejs在服务器端的开发更规范，而且与java共生。

	其中的ecm开发工具包兼有spring、osgi、nodejs的功能。支持面向模块开发与部署，热插拔。 	
	其中的net开发工具包,支持web的开发，并且可以完全使用js开发web应用，它的语法更接近于流行的nodejs，其它实现有基于netty的nio和自行开发的nio框架rio,rio叫响应式nio框架，它即有nio的优势，又有同步等待响应的能力。
	其中的plus开发工具包，进一步增强了连接的能力，如web应用的插件化（支持像eclipse这样的插件架构），支持像webservice这种远程服务的能力，支持云计算芯片的开发。
	其中的netdisk是基于mongodb的增加工具，它实现了网盘的各种功能，支持文件存取及结构化数据存取，支持多维，用户配额，开发上类似支持、对象映射支持。
	其中的神经元命令行工具，具有像tomcat/jetty等服务容器的功能，更多的是它具有向后连接的特性，是组建大型分布式神经网络的节点工具。它的目的就是组建神经网络集群。
	其中的mdisk命令行工具，它是以命令行窗口实现的网盘工具，以netdisk为核心，方便mongodb的开发、测试和运维管理。它用起来非常简单，只要连到你的mongodb即可将mongodb当成网盘数据库，且对原mongodb的库不受影响。
	其中的cjnet 用于调试neuron中的应用程序和netsite中的应用程序，它是一个cj studio中有关net产品开发和调试必不可少的工具。
	其中的netsite也是一个像tomcat/jetty等服务容器的命令行工具，它与神经元的区别在于，它只能部署在神经网络的终端，而不能成为其中间节点。它的优点在于，它可以部署成百上千个应用，而在一个神经元节点上一般不这么做。此工具暂时停止了升级。
	
· 介绍： ecm 面向连接电子模型开发工具包 http://cjlns.com/portlets/center/portlet-00002-coding/views/intro_ecm.html
· 介绍： net 通讯开发工具包 http://cjlns.com/portlets/center/portlet-00002-coding/views/intro_net.html
· 介绍： plus 模块化、插件化、服务化增强开发工具包 http://cjlns.com/portlets/center/portlet-00002-coding/views/intro_plus.html
· 介绍： netdisk 多维云盘开发工具包 http://www.cjlns.com/portlets/center/portlet-00002-coding/views/intro_netdisk.html
· 介绍： neuron 分布式连接容器 http://cjlns.com/portlets/center/portlet-00002-coding/views/intro_neuron.html
· 介绍： netsite 热插拔应用容器 http://www.cjlns.com/portlets/center/portlet-00002-coding/views/intro_netsite.html
· 介绍： mdisk 多维云盘命令行工具 http://www.cjlns.com/portlets/center/portlet-00002-coding/views/intro_mdisk.html
· 介绍： cjnet 调试、测试命令行工具 http://www.cjlns.com/portlets/center/portlet-00002-coding/views/intro_cjnet.html


cj studio的产品系列，有一部分遵循apache开源协议的，一部分是开放而暂未开源的，但是均可在商业中免费使用。

	对于开源我是这么看的，许多用户并不关心你的源码，也从来不看，一般都是直接引用jar，反倒开源使他们无从下载，不知从何入手，因此我才没有将那几个开发工具包的源码放上去。但是，对于尚未开源的核心源码，视开发者的呼声，随时都可以放上去。

示例和第三方开发的开放源码托管到 github, codeproject, sourceforge，oschina, csdn，基本每日更新。

最新消息在两个地方发布：
1. 云网官方网站：http://www.cjlns.com，发布产品消息，提供在线演示，交流相关技术，分享互联网创业经验，欢迎访问。
2. 每日源码更新动态，可以通过 Github 自带的动态消息 查看

源码托管网址(全部同步)：
* (国外)GitHub: https://github.com/carocean/examples
* (国外)codeproject: http://www.codeproject.com
* (国外)sourceforge: http://www.sourceforge.com
* (国内)开源中国: http://git.oschina.net/
* (国内)CSDN: https://code.csdn.net/

web开发使用js作为服务的示例：

	/*
	 * 说明：
	 * 作者：extends可以实现一种类型，此类型将可在java中通过调用服务提供器的.getServices(type)获取到。
	 * <![jss:{
			scope:'runtime'
	 	}
	 ]>
	 <![desc:{
		ttt:'2323',
		obj:{
			name:'09skdkdk'
			}
	 * }]>
	 */
	//var imports = new JavaImporter(java.io, java.lang)导入类型的范围，单个用Java.type
	var Frame = Java.type('cj.studio.ecm.frame.Frame');
	var FormData = Java.type('cj.studio.ecm.frame.FormData');
	var FieldData = Java.type('cj.studio.ecm.frame.FieldData');
	var Circuit = Java.type('cj.studio.ecm.frame.Circuit');
	var ISubject = Java.type('cj.lns.chip.sos.website.framework.ISubject');
	var String = Java.type('java.lang.String');
	var CircuitException = Java.type('cj.studio.ecm.graph.CircuitException');
	var ServiceosWebsiteModule = Java
			.type('cj.lns.common.sos.website.moduleable.ServiceosWebsiteModule');
	var Gson = Java.type('cj.ultimate.gson2.com.google.gson.Gson');
	var StringUtil = Java.type('cj.ultimate.util.StringUtil');
	var Document = Java.type('org.jsoup.nodes.Document');
	var Jsoup = Java.type('org.jsoup.Jsoup');
	var WebUtil = Java.type('cj.studio.ecm.net.web.WebUtil');
	var IServicewsContext = Java.type('cj.lns.chip.sos.website.framework.IServicewsContext');
	var TupleDocument = Java.type('cj.lns.chip.sos.cube.framework.TupleDocument');
	var System = Java.type('java.lang.System');
	var colName='article.relatives';
	var HashMap = Java.type('java.util.HashMap');
	var SimpleDateFormat = Java.type('java.text.SimpleDateFormat');
	var Date = Java.type('java.util.Date');
	
	function createComment(map,cube,sws,circuit){
		var artid=map.get('artid');
		var to=map.get('to');
		var comment=map.get('comment');
		var thread=map.get('thread');
		var author='';//文章作者
		var reviewerface=sws.visitor().face();
		var reviewer=sws.visitor().principal();//评论者
		var ctime=System.currentTimeMillis();//评论时间
		//求作者
		var cjql="select {'tuple.creator':1} from tuple article.entities java.util.HashMap where {'_id':ObjectId('?(id)')}";
		var q=cube.createQuery(cjql);
		q.setParameter('id',artid);
		var doc=q.getSingleResult();
		author=doc.tuple().get('creator');
		if('@'==to){//评论给文章作者
			to=author;
		}else{
			to=to.substring(1,to.length);
		}
		
		var tuple=new HashMap();
		tuple.put('artid',artid);
		tuple.put('thread',thread);//所属的主贴
		tuple.put('reviewer',reviewer);
		tuple.put('reviewerFace',reviewerface);
		tuple.put('to',to);
		tuple.put('prefix','@');
		tuple.put('kind','comment');//评论类型
		tuple.put('comment',comment);
		tuple.put('ctime',ctime);
		var newdoc=new TupleDocument(tuple);
		var commentid=cube.saveDoc(colName,newdoc);
		
		var retmap=new HashMap();
		retmap.put('commentid',commentid);
		retmap.put('reviewerId',reviewer);
		retmap.put('to',to);
		retmap.put('reviewerFace',reviewerface);
		var format=new SimpleDateFormat("hh:mm MM月dd日");
		var timeDisplay=format.format(new Date(ctime));
		retmap.put('ctime',timeDisplay);
		circuit.content().writeBytes(new Gson().toJson(retmap).getBytes());
	}
	function delComment(map,cube,sws,circuit){
		var commentid=map.get('commentid');
		cube.deleteDoc(colName,commentid);
	}
	function toggleGreat(map,cube,sws,circuit){
		var artid=map.get('artid');
		//返回评论号，评论者的face
		var reviewerface=sws.visitor().face();
		var reviewer=sws.visitor().principal();//评论者
		//看看是否点了赞，如果是已点则取消
		var cjql="select {'tuple':'*'}.count() from tuple ?(colName) java.lang.Long where {'tuple.kind':'great','tuple.artid':'?(artid)','tuple.reviewer':'?(reviewer)'}";
		var q=cube.createQuery(cjql);
		q.setParameter('artid',artid);
		q.setParameter('colName',colName);
		q.setParameter('reviewer',reviewer);
		var count=q.count();
		if(count>0){//取消
			cube.deleteDocOne(colName,String.format("{'tuple.artid':'%s','tuple.reviewer':'%s','tuple.kind':'great'}",artid,reviewer));
			var retmap=new HashMap();
			retmap.put('reviewerId',reviewer);
			retmap.put('cancel','true');//是点赞还是取消
			retmap.put('reviewerFace',reviewerface);
			circuit.content().writeBytes(new Gson().toJson(retmap).getBytes());
		}else{
			var ctime=System.currentTimeMillis();//评论时间
			
			var tuple=new HashMap();
			tuple.put('artid',artid);
			tuple.put('reviewer',reviewer);
			tuple.put('reviewerFace',reviewerface);
			tuple.put('kind','great');//评论类型
			tuple.put('ctime',ctime);
			var newdoc=new TupleDocument(tuple);
			var greatid=cube.saveDoc(colName,newdoc);
			var retmap=new HashMap();
			retmap.put('reviewerId',reviewer);
			retmap.put('cancel','false');//是点赞还是取消
			retmap.put('reviewerFace',reviewerface);
			var format=new SimpleDateFormat("hh:mm MM月dd日");
			var timeDisplay=format.format(new Date(ctime));
			retmap.put('ctime',timeDisplay);
			circuit.content().writeBytes(new Gson().toJson(retmap).getBytes());
		}
	}
	function toggleFollow(map,cube,sws,circuit){
		var artid=map.get('artid');
		//返回评论号，评论者的face
		var reviewerface=sws.visitor().face();
		var reviewer=sws.visitor().principal();//评论者
		//看看是否关注了，如果是已点则取消
		var cjql="select {'tuple':'*'}.count() from tuple ?(colName) java.lang.Long where {'tuple.kind':'follow','tuple.artid':'?(artid)','tuple.reviewer':'?(reviewer)'}";
		var q=cube.createQuery(cjql);
		q.setParameter('artid',artid);
		q.setParameter('colName',colName);
		q.setParameter('reviewer',reviewer);
		var count=q.count();
		if(count>0){//取消
			cube.deleteDocOne(colName,String.format("{'tuple.artid':'%s','tuple.reviewer':'%s','tuple.kind':'follow'}",artid,reviewer));
			var retmap=new HashMap();
			retmap.put('cancel','true');//是关注还是取消
			circuit.content().writeBytes(new Gson().toJson(retmap).getBytes());
		}else{
			var ctime=System.currentTimeMillis();//评论时间
			var tuple=new HashMap();
			tuple.put('artid',artid);
			tuple.put('reviewer',reviewer);
			tuple.put('reviewerFace',reviewerface);
			tuple.put('kind','follow');//评论类型
			tuple.put('ctime',ctime);
			var newdoc=new TupleDocument(tuple);
			var greatid=cube.saveDoc(colName,newdoc);
			var retmap=new HashMap();
			retmap.put('cancel','false');//是点赞还是取消
			circuit.content().writeBytes(new Gson().toJson(retmap).getBytes());
		}
	}
	function doShare(map,cube,sws,circuit){
		
	}
	exports.flow = function(frame, circuit, plug, ctx) {
		var m = ServiceosWebsiteModule.get();
		var map=WebUtil.parserParam(new String(frame.content().readFully()));
		var sws=IServicewsContext.context(frame);
		var disk=m.site().diskOwner(sws.owner());
		if(!disk.existsCube(sws.swsid())){
			throw new CircuitException('404','视窗空间不存在');
		}
		var cube=disk.cube(sws.swsid());
		var action=map.get('action');
		switch(action){
		case 'comment':
			createComment(map,cube,sws,circuit);
			break;
		case 'great':
			toggleGreat(map,cube,sws,circuit);
			break;
		case 'follow':
			toggleFollow(map,cube,sws,circuit);
			break;
		case 'share':
			doShare(map,cube,sws,circuit);
			break;
		case 'delComment':
			delComment(map,cube,sws,circuit);
			break;
		}
		//circuit.content().writeBytes(String.format("{'id':'%s'}",phyId).getBytes())	;
	}