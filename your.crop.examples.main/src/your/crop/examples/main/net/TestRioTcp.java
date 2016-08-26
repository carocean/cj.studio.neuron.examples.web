package your.crop.examples.main.net;

import cj.studio.ecm.Assembly;
import cj.studio.ecm.IAssembly;
import cj.studio.ecm.adapter.IActuator;
import cj.studio.ecm.adapter.IAdaptable;
import cj.studio.ecm.graph.CircuitException;

public class TestRioTcp {

	public static void main(String[] args)
			throws InterruptedException, CircuitException {
		IAssembly a = Assembly.loadAssembly(
				"/Users/carocean/studio/examples/build/your.crop.examples.net/your.crop.examples.net-1.0.jar");
		a.start();
		Object obj = a.workbin().part("riotcp");
		IAdaptable at = (IAdaptable) obj;
		IActuator act = at.getAdapter(IActuator.class);
		act.exeCommand("testRiotcp");
		a.stop();
		a.unload();
	}


}
