package your.crop.examples.net;

import cj.studio.ecm.graph.AnnotationProtocolFactory;
import cj.studio.ecm.graph.GraphCreator;
import cj.studio.ecm.graph.IProtocolFactory;
import cj.studio.ecm.graph.ISink;

class MyHelloWorldCreator extends GraphCreator {
	@Override
	protected IProtocolFactory newProtocol() {
		// 指定常量工厂，即：graph所实现协议的代码表或常量表
		return AnnotationProtocolFactory.factory(IHelloProtocol.class);
	}

	@Override
	protected ISink createSink(String sink) {
		// 根据sink名创建sink
		return new MySink();
	}
}