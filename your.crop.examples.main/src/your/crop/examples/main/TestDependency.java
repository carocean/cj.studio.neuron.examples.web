package your.crop.examples.main;

import cj.studio.ecm.Assembly;
import cj.studio.ecm.adapter.IActuator;
import cj.studio.ecm.adapter.IAdaptable;

public class TestDependency {

	public static void main(String[] args) {
		testFindExotericServiceInOtherChip();
		testParentChip1();
	}
	static void testParentChip1() {
		String cf1 = "/Users/carocean/studio/examples/build/your.crop.examples.chip1/your.crop.examples.chip1-1.0.jar";
		String cf2 = "/Users/carocean/studio/examples/build/your.crop.examples.ecm/your.crop.examples.ecm-1.0.jar";
		Assembly a1 = Assembly.loadAssembly(cf1);
		Assembly a2 = Assembly.loadAssembly(cf2);
		a2.parent(a1);
		a2.start();
		a1.unload();
		a2.unload();
	}
	static void testFindExotericServiceInOtherChip() {
		// 演示依赖关系：
		/*
		 * 1.在chip1中定义外部接口IDeptmemt 2.在chip2中实现该外部接口
		 * 3.在chip1中搜索所有依赖于它的芯片中的IDeptmemt实现 对于一个可扩展的系统来说，此架构是非常有用的。一级一级的扩展芯片
		 */
		String cf1 = "/Users/carocean/studio/examples/build/your.crop.examples.chip1/your.crop.examples.chip1-1.0.jar";
		String cf2 = "/Users/carocean/studio/examples/build/your.crop.examples.chip2/your.crop.examples.chip2-1.0.jar";
		Assembly a1 = Assembly.loadAssembly(cf1);
		Assembly a2 = Assembly.loadAssembly(cf2);
		a2.dependency(a1);
		a2.start();
		Object obj = a1.workbin().part("exotericService");
		IAdaptable a = (IAdaptable) obj;
		IActuator act = a.getAdapter(IActuator.class);
		act.exeCommand("testFindExotericServiceInOtherChip");
		a1.unload();
		a2.unload();
	}
}
