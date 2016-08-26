package your.crop.examples.ecm;

import cj.studio.ecm.annotation.CjService;

@CjService(name="javaPrinter")
public class JavaPrinter implements IPrinter {

	@Override
	public void printHello() {
		System.out.println("hello world java");
	}

}
