package your.crop.examples.net.nswitch;

import cj.studio.ecm.annotation.CjService;

import cj.studio.ecm.frame.Circuit;
import cj.studio.ecm.frame.Frame;
import cj.studio.ecm.frame.IFeedback;
import cj.studio.ecm.graph.CircuitException;
import cj.studio.ecm.graph.ICablePin;
import cj.studio.ecm.graph.IPin;
import cj.studio.ecm.graph.IPlug;
import cj.studio.ecm.graph.ISink;
import cj.studio.ecm.net.IClient;
import cj.studio.ecm.net.IConnectCallback;
import cj.studio.ecm.net.IRioClientCloseEvent;
import cj.studio.ecm.net.graph.INetGraph;
import cj.studio.ecm.net.nio.NetConstans;
import cj.studio.ecm.net.rio.local.LocalClientSwitch;
import cj.studio.ecm.net.rio.local.LocalServerSwitch;
/**
 * 注：对应用netty实现的LocalNettyServer,LocalNettyClient与用法与此类似，但对持响应式的支持性能没有rio的好
 * @author carocean
 *
 */
@CjService(name="nswitch",isExoteric=true)
public class TestRioSwitch {

	public void testNswitch()
			throws InterruptedException, CircuitException {

		LocalServerSwitch nswitchs = new LocalServerSwitch();
		nswitchs.setProperty("workThreadCount", "2");
		nswitchs.start("8080");
		nswitchs.buildNetGraph().netOutput().plugLast("test", new ISink() {

			@Override
			public void flow(Frame frame, Circuit circuit, IPlug plug)
					throws CircuitException {
				// TODO Auto-generated method stub
				System.out.println("server:" + frame + " " + plug.owner());
				if ("NET/1.1".equals(frame.protocol())) {
					return;
				}
				circuit.head("sss","xxxx");
				circuit.content().writeBytes("0000".getBytes());
				Frame f = new Frame("from /Server http/1.1");
				f.head(NetConstans.FRAME_HEADKEY_CIRCUIT_SYNC,"true");
				Circuit c = new Circuit("http/1.1 200 ok");
				// nswitchs.buildNetGraph().netInput().flow(f, c);
				 IFeedback fb=circuit.feedback(IFeedback.KEY_OUTPUT_FEEDBACK);
				 fb.doBack(f, c);
				 System.out.println("服务器"+new String(c.content().readFully()));
//				 circuit.attribute("net-action", "disconnect");
			}
		});
		
		LocalClientSwitch nswitchc = new LocalClientSwitch();
		nswitchc.setProperty("workThreadCount", "4");
		nswitchc.connect("localhost", "8080", new IConnectCallback() {

			@Override
			public void buildGraph(Object owner, INetGraph ng) {
				nswitchc.buildNetGraph().netOutput().plugLast("test",
						new ISink() {

							@Override
							public void flow(Frame frame, Circuit circuit,
									IPlug plug) throws CircuitException {
								// TODO Auto-generated method stub
								System.out.println(
										"client:" + frame + " " + plug.owner());
								if ("NET/1.1".equals(frame.protocol())) {
									return;
								}
								circuit.content().writeBytes("kdkdkddk".getBytes());
								IFeedback fb = circuit.feedback(
										IFeedback.KEY_OUTPUT_FEEDBACK);
								Frame f = new Frame("from /client http/1.1");
								Circuit c = new Circuit("http/1.1 200 ok");
//								fb.doBack(f, c);
								
//								circuit.attribute("net-action", "disconnect");
							}
						});

			}
		});

		Frame frame = new Frame("get / http/1.1");
		Circuit circuit = new Circuit("http/1.1 200 ok");
//		circuit.feedbackSetSource(IFeedback.KEY_INPUT_FEEDBACK);
//		IFeedback accept=circuit.feedback(IFeedback.KEY_INPUT_FEEDBACK);
//		accept.plugSink("ssss", new ISink() {
//			
//			@Override
//			public void flow(Frame frame, Circuit circuit, IPlug plug)
//					throws CircuitException {
//				// TODO Auto-generated method stub
//				System.out.println("----"+frame);
//			}
//		});
		nswitchc.onEvent(new IRioClientCloseEvent() {
			
			@Override
			public void onClosing(IClient client) {
				// TODO Auto-generated method stub
				System.out.println("关闭客端");
			}
		});
		ICablePin coutput=(ICablePin)nswitchc.buildNetGraph().netOutput();
		IPin in=nswitchc.buildNetGraph().netInput();
		frame.head(NetConstans.FRAME_HEADKEY_CIRCUIT_SYNC,"true");
		in.flow(frame, circuit);
		System.out.println("内容："+new String(circuit.content().readFully()));
		Thread t=new Thread(new Runnable() {
			public void run() {
				nswitchc.close();
			}
		});
		Thread t2=new Thread(new Runnable() {
			public void run() {
				nswitchs.stop();
			}
		});
//		t2.start();
//		t.start();
		
//		 nswitchc.close();
		 nswitchs.stop();

	}

}
