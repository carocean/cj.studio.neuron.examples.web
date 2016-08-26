package your.crop.examples.website.pages;

import org.jsoup.nodes.Document;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.frame.Circuit;
import cj.studio.ecm.frame.Frame;
import cj.studio.ecm.graph.CircuitException;
import cj.studio.ecm.graph.IPlug;
import cj.studio.ecm.net.web.page.Page;
import cj.studio.ecm.net.web.page.context.PageContext;

//import cj.studio.ecm.net.web.sink.WebSocketServerIndexPage;

@CjService(name = "/pages/")
public class HomePage extends Page {
	@Override
	public void doPage(Frame frame,Circuit circuit, IPlug plug, PageContext ctx)
			throws CircuitException {
		// TODO Auto-generated method stub
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		System.out.println(cl);
		System.out.println("home service:");
		System.out.println(plug.site().getProperty("http.root"));
		String path = "ws://" + frame.head("Host") + "/"
				+ circuit.attribute("select-name")
				+ circuit.attribute("websocket-path") + "/widgets/";
		// ByteBuf content = WebSocketServerIndexPage.getContent(path);
		// circuit.content().writeBytes(content);
		// content.release();
		Document doc = ctx.html("/index.html", "gbk");
		circuit.content().writeBytes(doc.toString().getBytes());
	}

}
