package cj.test.jeewebsite.webview;

import java.io.IOException;

import org.jsoup.nodes.Document;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.graph.CircuitException;
import cj.studio.ecm.net.jee.IJeeSiteResource;
import cj.studio.ecm.net.jee.IJeeWebView;
import cj.studio.ecm.net.jee.JeeHttpRequest;
import cj.studio.ecm.net.jee.JeeHttpResponse;

@CjService(name="/")
public class Home implements IJeeWebView{

	@Override
	public void flow(JeeHttpRequest req, JeeHttpResponse resp,
			IJeeSiteResource resource)throws CircuitException, IOException {
		System.out.println("-----++++"+req);
		Document doc=resource.html("/index.html");
		resp.getWriter().write(doc.toString());
	}
	
}
