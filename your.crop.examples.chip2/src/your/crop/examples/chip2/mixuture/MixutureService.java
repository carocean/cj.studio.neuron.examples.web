package your.crop.examples.chip2.mixuture;

import cj.studio.ecm.Scope;
import cj.studio.ecm.annotation.CjPropertyValue;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.bridge.UseBridgeMode;
import your.crop.examples.chip2.jss.ITestJss;
import your.crop.examples.chip2.xml.IXmlService;

//混合服务，注解、JSON/XML
@CjService
public class MixutureService {
	@CjPropertyValue(parser="cj.basic",value="2")
	private int age;
	@CjPropertyValue(parser="cj.basic",value="3")
	private int age2;
	
	private Object jsonObject;
	
	private IXmlService xmlservice;
	@CjServiceRef(refByName="$.cj.jss.test.JssPrinter")
	ITestJss testJss;
	
	@CjServiceRef(refByName="annoObject2",useBridge=UseBridgeMode.forbidden)
	private Object myObject;
	
	public ITestJss getTestJss() {
		return testJss;
	}
}
