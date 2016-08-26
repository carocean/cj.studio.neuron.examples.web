package your.crop.examples.net;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.graph.Access;
import cj.studio.ecm.graph.Graph;
import cj.studio.ecm.graph.GraphCreator;

@CjService(name = "helloWorld", isExoteric = true)
public class MyHelloWorldGraph extends Graph {
	@Override
	protected String defineAcceptProptocol() {
		return ".*";//指定graph的可接受协议
	}

	@Override
	protected GraphCreator newCreator() {
		// graph的构建器，很重要
		return new MyHelloWorldCreator();
	}

	@Override
	protected void build(final GraphCreator c) {
		//构建了两个端子，输入输出
		c.newWirePin("input", Access.input).plugLast("mySink",
				c.newSink("mySink"));
		c.newWirePin("output", Access.output);
	}



	
}
