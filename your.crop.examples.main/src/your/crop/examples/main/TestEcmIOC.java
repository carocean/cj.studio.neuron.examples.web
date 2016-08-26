package your.crop.examples.main;

import java.util.List;

import cj.studio.ecm.Assembly;
import cj.studio.ecm.ServiceCollection;
import cj.studio.ecm.adapter.IActuator;
import cj.studio.ecm.adapter.IAdaptable;

public class TestEcmIOC {
	public static void main(String... strings) {
		String cf1 = "/Users/carocean/studio/examples/build/your.crop.examples.chip1/your.crop.examples.chip1-1.0.jar";
		String cf2 = "/Users/carocean/studio/examples/build/your.crop.examples.chip2/your.crop.examples.chip2-1.0.jar";
		Assembly a1 = Assembly.loadAssembly(cf1);
		Assembly a2 = Assembly.loadAssembly(cf2);
		a2.dependency(a1);
		a2.start();
		Object obj = a2.workbin().part("chip2main");
		IAdaptable a = (IAdaptable) obj;
		IActuator act = a.getAdapter(IActuator.class);
		act.exeCommand("testMyXmlService");
		act.exeCommand("testMyAnnoService");
		act.exeCommand("refMethodInXmlService");
		act.exeCommand("refXmlServiceByGridge");
		act.exeCommand("testMyJsonService");
		
		List<Class<?>> mys=a2.workbin().exotericalType("my");
		for(Class<?> c:mys){
			ServiceCollection<?> col=a2.workbin().part(c);
			System.out.println("-----这是按外部指定分类搜到的服务数："+col.size());
		}
		a1.unload();
		a2.unload();
	}

}
