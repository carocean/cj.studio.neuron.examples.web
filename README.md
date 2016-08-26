本例程源自：http://www.cjlns.com
cjlns.com平台，是以面向连接编程实现的，从架构到部署均采用了连接体系。

 《面向连接编程》http://www.cjlns.com/portlets/center/portlet-00001-show/views/ecm.html
 
	你还在用spring做应用的逻辑单元架构吗？
	你还在用osgi来开发你的模块吗？
	你还在用j2ee这种过时的陈米吗？
	你还在用zookeeper来同步状态吗？
	你还在用tomcat/jetty等运行应用吗？
	你还在用nodejs开发服务器端程序吗？
	你还在用jms等做消息中间件吗？
	你还在用X+Y-Z披着满身的补丁来做网站的分布式架构吗？
	别了，struts,spring mvc，tapstry，别了，All of 它们！
	它们都倍儿显老迈。
	世界形式，老的终去，新的始来，它们，只是历史。
	新十年的编程思想和工具诞生了，它是业界的一场飓风，一场革命。
	它引领程序员向面向连接、面向模块、面向协议更为简易、更为规范，更好的分工，尤其适合大规模的团队。
	它是未来10年java领域的主流技术
	
面向连接编程是一个完整的工具体系
	其中的ecm开发工具包兼有spring、osgi、nodejs的功能。支持面向模块开发与部署，热插拔。 	
	其中的net开发工具包，实现有基于netty的nio和自行开发的nio框架rio,rio叫响应式nio框架，它即有nio的优势，又有同步等待响应的能力。
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


