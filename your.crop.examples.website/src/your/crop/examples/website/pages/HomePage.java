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

@CjService(name = "/index.html")
public class HomePage extends Page {
	@Override
	public void doPage(Frame frame,Circuit circuit, IPlug plug, PageContext ctx)
			throws CircuitException {
		Document doc = ctx.html("/index.html", "utf-8");
		//演示为表单赋值
		doc.select(".a>ul>li[name]>input[name]").attr("value","小哈哈");
		doc.select(".a>ul>li[age]>input[name]").attr("value","4");
		circuit.content().writeBytes(doc.toString().getBytes());
	}
}
