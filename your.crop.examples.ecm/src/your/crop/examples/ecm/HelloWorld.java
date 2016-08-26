package your.crop.examples.ecm;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import your.crop.examples.common.IHelloWorld;

@CjService(name="helloWorld",isExoteric=true)
public class HelloWorld implements IHelloWorld{
	@CjServiceRef()
	private IPrinter javaPrinter;
	@CjServiceRef(refByName="$.cj.jss.ecm.JssPrinter")
	private IPrinter jssPrinter;
	public void echoByJavaPrinter(){
		javaPrinter.printHello();
	}
	public void echoByJssPrinter(){
		jssPrinter.printHello();
	}
}
