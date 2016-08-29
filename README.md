 Keywords: J2EE, Java, nodejs, OSGi, JSP, struts, spring, spring, MVC, mongodb, radis, zookeeper, netty, Mina, jetty, Tomcat, Weblogic, WebSphere, ORM, cloud, nashron, JDK

	 (website: http://cjlns.com)

"Connection oriented programming" Http://www.cjlns.com/portlets/center/portlet-00001-show/views/ecm.html

	Connection oriented programming is a complete tool system, from web to MVC persistence layer, the deployment of development tools from tools to distributed, from the local to the remote service container, a complete set of system development and deployment, which users can get rid of that spell development and system operation status of the mending spell.

Is a connection oriented tool system's advantage, at the architecture level, more than spring easy to use, save more than OSGi, than the development of nodejs on the server with the Java standard, and symbiosis. It supports building large-scale distributed operation environment such as neural network

	 The ECM development kit with spring, OSGi, nodejs function. Support for module development and deployment, hot swap. 
	 the net development kit, support the development of web, and can fully use js to develop web application, its syntax is more close to the popular nodejs, other features include netty based NiO framework also includes the NiO developed by Rio, called Rio responsive NiO framework, which has the advantages of NiO, and the synchronous wait for a response. 
	 the plus development kit, to further enhance the capacity of the connection, such as web application plug-ins (support such as eclipse plug-in architecture), such as WebService remote service support capabilities, support cloud computing chip. The 
	 enhanced netdisk is developed based on mongodb toolkit, it implements the various SkyDrive function, support random access file and structured data access, support multidimensional, user quotas, the development of similar SQL syntax support, object mapping. 
	 The neuron which command line tools, such as tomcat/jetty service container has a function, it is more connected with backward characteristics, the node is the formation of large-scale distributed neural network. It is the purpose of the formation of neural network clusters. 
	 The mdisk command line tool, which is based on the command line window to achieve the SkyDrive tool, using netdisk as the core of the development, testing and maintenance, convenient mongodb. It is very simple to use, as long as you can be connected to the mongodb mongodb database as SkyDrive, and the original mongodb library is not affected. 
	 The application of cjnet for debugging in neuron application program and netsite program, it is a product of net in CJ studio system development and debugging of essential products. 
	netsite which is also a service container like tomcat/jetty command-line tool, and it differs from that of neurons, it can only be deployed in the network terminal, and can not become the middle. Its advantage is that it can be deployed hundreds of applications, and in a neuron node generally do not do so. This tool is to temporarily stop the upgrade.

	Introduction: 
	ECM Development kit Http://cjlns.com/portlets/center/portlet-00002-coding/views/intro_ecm.html Introduction: 
	Net Development Kit Http://cjlns.com/portlets/center/portlet-00002-coding/views/intro_net.html 
	plus Development Kit, plug-in technology and services enhanced development kit Http://cjlns.com/portlets/center/portlet-00002-coding/views/intro_plus.html 
	netdisk development kit Http://www.cjlns.com/portlets/center/portlet-00002-coding/views/intro_netdisk.html 
	neuron hot plug application container Http://cjlns.com/portlets/center/portlet-00002-coding/views/intro_neuron.html 
	netsite hot plug application container Http://www.cjlns.com/portlets/center/portlet-00002-coding/views/intro_netsite.html
	mdisk cloud disk command line tool Http://www.cjlns.com/portlets/center/portlet-00002-coding/views/intro_mdisk.html 
	cjnet command-line tools for debugging and testing Http://www.cjlns.com/portlets/center/portlet-00002-coding/views/intro_cjnet.html

Introduction：

 From the entry of the HelloWorld http://www.cjlns.com/portlets/center/portlet-00002-coding/views/ecm_hello.html
 ECM toolkit from net toolkit HelloWorld entry http://www.cjlns.com/portlets/center/portlet-00002-coding/views/net_hello.html
 helloword into http://www.cjlns.com/portlets/center/portlet-00003-develop/views/neuron_hello.html
 neurons connect to cloud computer chip development process: helloword introduction http://www.cjlns.com/portlets/center/portlet-00004-computer/views/computer_hello.html

This is the root of engineering structure: your.crop project, the global directory under the cjtools directory in CJ studio related development kit, runtime CJ studio directory products operation must rely on the package for your.crop.examples.main testing project

CJ studio series of products, some follow the Apache open source protocol, a part is open and not open source, but are free to use in business.

 My view is that for open source, many users do not care about your source, never see, generally use jar directly, but they can not make open source download, do not know where to start, so I did not the development kit source put up. However, for the core source code has not yet been open source, as the developer's voice, can put up at any time.

The sample and third party developers of open source hosting to GitHub, CodeProject, SourceForge, oschina, CSDN, basic daily updates.

The latest news released in two places: 

	1. network official website: Http://www.cjlns.com, product release news, online presentation, communication technology, Internet entrepreneurs to share experience, welcome to visit. Cloud platform itself is connected with neural network cluster programming oriented, from the architecture to deploy all the connecting system of neurons, a total of 5 machines, distributed network connected from the pre - Application of neural machine machine neurons interneurons machine. In addition to the cloud platform for connection oriented programming system, also used at least 5 projects. 
	2. daily source updates can be dynamic message by Github's own view

The source web site hosting (full synchronization):

    (foreign) GitHub: Https://github.com/carocean/examples
    (foreign) sourceforge: Https://sourceforge.net/p/cjlns/examples/ci/master/tree/
    (domestic) open source Chinese: Https://git.oschina.net/carocean/examples
    (domestic) CSDN: Https://code.csdn.net/qq_35955798/examples

The development of Web services using JS as example:

	/*
	 * 2016.0829
	 * 作者：赵向彬
	 * 说明：extends可以实现一种类型，此类型将可在java中通过调用服务提供器的.getServices(type)获取到。这样在java代码中直接使用接口间接的调用到jss实现
	 * 注意使用extends的限制：
	 * 1.jss必须实现该接口的方法，而且一定是导出方法，即声明为exports.method=function格式
	 * 	isStronglyJss:true 表示该jss服务使用强jss类型对象，必须指定extends派生接口，这在以注入方式引用jss服务时非常有用，默认是弱类型，即返回ScriptObjectMirror类型
	 * 2.filter使用它需要在assembly.json中开启过滤器模式，它用于拦截java服务的方法，即此机制实现了以jss代理java的功能
	 * 
	 * 缺陷：java8 nashorn 在jdk8 65u之后的版本存在缺陷65u正常
	 * 描述：绑定域可见性缺陷，比如一个jss服务的imports域，在非函数代码中可以打印出来，在函数（如：exports.test=function())代码段内却报imports未定义异常。
	 * ScriptContext.ENGINE_SCOPE
	 * 老外分析：jdk8 102版也存在此问题，95版也存在
	 * http://stackoverflow.com/questions/37611959/java-8-passing-a-function-through-bindings
	 * <![jss:{
			scope:'runtime',
			extends:'',
			filter:{
		 	}
	 	},
	 	shit:{
	 		name:"fuck"
	 	}
	 ]>
	*/
	
	//var imports = new JavaImporter(java.io, java.lang);
	//with (imports) {  
	//  var file = new File(__FILE__);  //查找我在哪里？
	//  System.out.println('哪里: ' + file.getAbsolutePath());   //内容比较古怪
	  // /path/to/my/script.js
	//}
	var FormData = Java.type('cj.studio.ecm.frame.FormData');
	var String = Java.type('java.lang.String');
	var WebUtil=Java.type('cj.studio.ecm.net.web.WebUtil');
	
	exports.doPage = function(frame,circuit, plug, ctx) {
		print('Content-Type:'+frame.contentType());
		var data = frame.content().readFully();
		var params=WebUtil.parserParam(new String(data));
		print(params);
		
		var doc = ctx.html("/pages/response.html", "utf-8");
		//使用类似jquery的语法来为dom fu zhi，我操他妈哩个比的汉字，打字这么难。
		doc.select('.response>span[name]').html(params.name);
		doc.select('.response>span[age]').html(params.age);
		
		var session=frame.session();
		print('------会话实例：'+session);
		
		 print('------打印jss服务的导入属性和所在芯片信息---------');
		   print('module_name:' + imports.module_name);
		   print('module_home:' + imports.module_home);
		   print('module_ext:' + imports.module_extName);
		   print('module_pack:' + imports.module_package);
		   print('module_unzip:' + imports.module_unzip);
		   print('module_type:' + imports.module_type);
		   print('head jss scope:'+imports.head.jss.scope);
		   print('head shit name:'+imports.head.shit.name);
		   print('location:' + imports.locaction);
		   print('source:' + imports.source);
		   print('selectKey1:' + imports.selectKey1);
		   print('selectKey2:' + imports.selectKey2);
		   print('this is jss chip site ' + chip.site());
		   print('---------');
		   
		circuit.content().writeBytes(doc.toString().getBytes());
	}

