package your.crop.examples.net.http;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.frame.Circuit;
import cj.studio.ecm.frame.Frame;
import cj.studio.ecm.graph.CircuitException;
import cj.studio.ecm.graph.ICablePin;
import cj.studio.ecm.graph.IPin;
import cj.studio.ecm.graph.IPlug;
import cj.studio.ecm.graph.ISink;
import cj.studio.ecm.net.nio.NetConstans;
import cj.studio.ecm.net.nio.netty.http.HttpNettyServer;
import cj.studio.ecm.net.rio.http.JdkHttpClient;
//现在http server只有netty的实现，而http客户端即有netty的实现也有基于jdk的实现
@CjService(name="http",isExoteric=true)
public class TestHttp {
	public void testHttp() throws InterruptedException, CircuitException{
		HttpNettyServer httpserver=new HttpNettyServer();
		httpserver.setProperty("workThreadCount", "2");
		httpserver.start("8881");
		httpserver.buildNetGraph().netOutput().plugLast("test", new ISink() {

			@Override
			public void flow(Frame frame, Circuit circuit, IPlug plug)
					throws CircuitException {
				// TODO Auto-generated method stub
				System.out.println("server:" + frame + " " + plug.owner());
				if ("NET/1.1".equals(frame.protocol())) {
					return;
				}
				circuit.head("sss","xxxx");
				circuit.content().writeBytes("0000".getBytes());//写个0000
				Frame f = new Frame("from /Server http/1.1");
//				f.head(NetConstans.FRAME_HEADKEY_CIRCUIT_SYNC,"true");
				Circuit c = new Circuit("http/1.1 200 ok");
				// nswitchs.buildNetGraph().netInput().flow(f, c);
				 System.out.println("服务器"+new String(c.content().readFully()));
				 circuit.content().writeBytes("<div>fuck</div>".getBytes());
//				 circuit.attribute("net-action", "disconnect");
			}
		});
		//在此设个断点堵住，测试在浏览器中访问：http://localhost:8881/    显示应是：0000<br>fuck，然后跳过断点，会看到httpclient的输出
		JdkHttpClient httpclient=new JdkHttpClient();
		httpclient.setProperty("workThreadCount", "10");
		
		httpclient.connect("localhost", "8881");
		
		ICablePin coutput=(ICablePin)httpclient.buildNetGraph().netOutput();
		IPin in=httpclient.buildNetGraph().netInput();
		Frame frame = new Frame("get / http/1.1");
		Circuit circuit = new Circuit("http/1.1 200 ok");
		frame.head(NetConstans.FRAME_HEADKEY_CIRCUIT_SYNC,"true");
		in.flow(frame, circuit);
		System.out.println("内容："+new String(circuit.content().readFully()));
		
		httpclient.close();
		httpserver.stop();
	}
}
