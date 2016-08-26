package your.crop.examples.main;

import cj.studio.ecm.Assembly;
import cj.studio.ecm.IAssembly;
import cj.studio.ecm.adapter.IActuator;
import cj.studio.ecm.adapter.IAdaptable;
import your.crop.examples.common.IHelloWorld;

public class TestEcmMain {

	public static void main(String[] args) {
		 testExeHelloworldByAdapater();
		testExeHelloworldByObType();
	}

	static void testExeHelloworldByObType() {
		
		/*
		 * 说明： 此处采用适配器方式调用外部服务:helloworld，这是弱类型调用
		 * 如果想以强类型调用，可设置一公共的common包(非程序集），main项目引用此包，ecm项目的cj.references下放置此包，
		 * 即可在main中强制转换为相应类型
		 */
		IAssembly a = Assembly.loadAssembly(
				"/Users/carocean/studio/examples/build/your.crop.examples.ecm/your.crop.examples.ecm-1.0.jar");
		a.start();
		Object obj = a.workbin().part("helloWorld");
		IHelloWorld hw = (IHelloWorld) obj;
		hw.echoByJavaPrinter();
		hw.echoByJssPrinter();
	}

	static void testExeHelloworldByAdapater() {
		/*
		 * 说明： 此处采用适配器方式调用外部服务:helloworld，这是弱类型调用
		 * 如果想以强类型调用，可设置一公共的common包(非程序集），main项目引用此包，ecm项目的cj.references下放置此包，
		 * 即可在main中强制转换为相应类型
		 */
		IAssembly a = Assembly.loadAssembly(
				"/Users/carocean/studio/examples/build/your.crop.examples.ecm/your.crop.examples.ecm-1.0.jar");
		a.start();
		Object obj = a.workbin().part("helloWorld");
		
		IAdaptable adaptable = (IAdaptable) obj;
		IActuator act = adaptable.getAdapter(IActuator.class);
		act.exeCommand("echoByJavaPrinter");
		act.exeCommand("echoByJssPrinter");
	}

}
