package your.crop.examples.website;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.graph.GraphCreator;
import cj.studio.ecm.net.layer.ISession;
import cj.studio.ecm.net.layer.ISessionEvent;
import cj.studio.ecm.net.web.WebSiteGraph;
import cj.studio.ecm.net.web.WebSiteGraphCreator;
//这个图可以上netsite
//或者从CompatibleWebsiteGraph派生，原因：如果你的webgraph想对接非httpserver服务器net，如udtServer,tcpServer等 ,则应使用兼容图,兼容图会被其它协议转换为:httpFrame,httpCircuit
@CjService(name = "myWebSiteGraph",isExoteric=true)
public class MyWebSiteGraph extends WebSiteGraph {
	@Override
	protected GraphCreator newCreator() {
		return new MySiteGraphCreator();
	}

	public class MySiteGraphCreator extends WebSiteGraphCreator {
		
	}
	//侦听会话的事件，如：会话新增、退出、属性的增减等
	public class SessionManagerEvent implements ISessionEvent {

		@Override
		public void doEvent(String eventType, Object... args) {
			System.out.println("MyWebSiteGraph :"+eventType+" "+((ISession)args[0]).id());
			
		}
		
	}
}
