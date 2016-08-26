package your.crop.examples.website.widget;

import java.io.IOException;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.frame.Circuit;
import cj.studio.ecm.frame.Frame;
import cj.studio.ecm.graph.CircuitException;
import cj.studio.ecm.graph.IPlug;
import cj.studio.ecm.net.web.HttpCircuit;
import cj.studio.ecm.net.web.HttpFrame;
import cj.studio.ecm.net.web.widget.Widget;
import cj.studio.ecm.net.web.widget.context.WidgetContext;
@CjService(name="/read")
public class MyWidget extends Widget {

	public MyWidget() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doWidget(Frame frame,Circuit circuit, IPlug plug, WidgetContext ctx)
			throws CircuitException {
		try {
			System.out.println("要回发的侦："+new String(frame.toBytes()));
			String text=ctx.resourceText("/2.txt");
			
//			HttpPin out=(HttpPin)plug.circuit().feedback("_output__WsSink");
//			HttpFrame hf=(HttpFrame)frame;
			Circuit c=new HttpCircuit("test/1.1 200 ok");
			c.attribute("select-id",circuit.attribute("select-id"));
//			c.head("remote-device")
			
			//在neuron下注释掉，在netsite下开启，因为neuron下只读回路中的select-id，而在netsite下即可认侦中的也认回路中的
//			HttpFrame f=new HttpFrame(String.format("push /%s?select-id=%s http/1.1",circuit.attribute("select-name"),circuit.attribute("select-id")));
			HttpFrame f=new HttpFrame(String.format("push / http/1.1"));
			frame.content().clear();
			f.content().writeBytes(text.getBytes());
			f.contentType("frame/bin");
			//如果在lns网络中使用了共享远程目标，则回发的时候要选定远程设备，否则将以广播方式回传给所有连接了回馈回路的设备。
			if(frame.containsHead("remote-device")){
				f.head("remote-device",frame.head("remote-device"));
			}
//			out.flow(f, c);
//			plug.circuit().feedback().doBack(f,c);
			if(!circuit.isEmptyFeedback()){
				String[] a=circuit.enumFeedback();
				for(String k:a){
					circuit.feedback(k).doBack(f,c);
				}
			}
//			out.sendBySessionId(hf.session().id(), f, c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
