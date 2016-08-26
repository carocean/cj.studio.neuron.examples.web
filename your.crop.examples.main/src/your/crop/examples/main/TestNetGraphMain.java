package your.crop.examples.main;

import cj.studio.ecm.Assembly;
import cj.studio.ecm.IAssembly;
import cj.studio.ecm.frame.Circuit;
import cj.studio.ecm.frame.Frame;
import cj.studio.ecm.graph.CircuitException;
import cj.studio.ecm.graph.IGraph;
import cj.studio.ecm.graph.IPin;

public class TestNetGraphMain {

	public static void main(String[] args) throws CircuitException {
		testExeHelloworldByObType();
	}

	static void testExeHelloworldByObType() throws CircuitException {
		
		IAssembly a = Assembly.loadAssembly(
				"/Users/carocean/studio/examples/build/your.crop.examples.net/your.crop.examples.net-1.0.jar");
		a.start();
		Object obj = a.workbin().part("helloWorld");
		IGraph g = (IGraph) obj;
		if(!g.isInit()){
			g.initGraph();
		}
		IPin input=g.in("input");
		Frame frame=new Frame("get /helloworld hlwd/1.0");
		Circuit circuit=new Circuit("hlwd/1.0 200 ok");
		input.flow(frame, circuit);
	}


}
