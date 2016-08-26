package your.crop.examples.chip2;

import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjExotericalType;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.frame.Circuit;
import cj.studio.ecm.frame.Frame;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import your.crop.examples.chip2.anno.AnnoObject;
import your.crop.examples.chip2.anno.IAnnoService;
import your.crop.examples.chip2.anno.MyAnnoService;
import your.crop.examples.chip2.anno.RefMethodInXmlService;
import your.crop.examples.chip2.json.MyJsonService;
import your.crop.examples.chip2.jss.IJssPage;
import your.crop.examples.chip2.jss.ITestJss;
import your.crop.examples.chip2.mixuture.MixutureService;
import your.crop.examples.chip2.xml.IXmlService;
import your.crop.examples.chip2.xml.MyXmlService;
import your.crop.examples.chip2.xml.RefXmlServiceByGridge;
@CjExotericalType(typeName="my")
@CjService(name = "chip2main", isExoteric = true)
public class Chip2Main {
	@CjServiceRef()
	IXmlService myXmlService;
	@CjServiceRef(refByName = "myAnnoService")
	IAnnoService myAnnoService;
	@CjServiceRef(refByName = "refMethodInXmlService")
	RefMethodInXmlService refMethodInXmlService;
	@CjServiceRef
	RefXmlServiceByGridge refXmlServiceByGridge;
	@CjServiceRef
	MyJsonService myJsonService;
	@CjServiceRef(refByType=MixutureService.class)
	MixutureService mixutureService;
	@CjServiceSite
	IServiceSite site;
	public void testMyXmlService() {
		System.out.println(myXmlService + " 这是注入name的值：" + myXmlService.getName());
		System.out.println(myXmlService + " 这是注入map的值：" + myXmlService.getMap());
		System.out.println(myXmlService + " 这是注入list的值：" + myXmlService.getList());
		System.out.println(myXmlService + " 这是注入的服务（它自身）：" + myXmlService.getService());
		Object obj = MyXmlService.newService("sss", "bbb", null);
		System.out.println(myXmlService + " 这是注入的服务（它自身）：" + obj);
		System.out.println(myXmlService + " 这是通过自定义的值解析器注入的对象：" + myXmlService.getIocByMyValueParser());
	}

	public void refMethodInXmlService() {
		Object obj = refMethodInXmlService.getMyjsonService();
		Object obj2 = refMethodInXmlService.getMyXmlService();
		IXmlService obj3 = refMethodInXmlService.getMyXmlServiceByBridgeForbidden();
		IXmlService obj4 = refMethodInXmlService.getMyXmlServiceByBridgeNormal();
		IXmlService obj5 = refMethodInXmlService.getXmlServiceWithPrivateAspectSet();
		System.out.println(refMethodInXmlService + " 这是调用getMyjsonService的值：" + obj);
		System.out.println(refMethodInXmlService + " 这是调用getMyXmlService的值：" + obj2);
		System.out.println(refMethodInXmlService + " 这是通过自动桥接获取的对象，且具有私有方面设置（减去了myaspect1)：" + obj5);
		obj5.getList();
		System.out.println(refMethodInXmlService + " 这是通过禁用桥接获取的对象：" + obj3);
		obj3.getList();
		System.out.println(refMethodInXmlService + " 这是通过正常桥接获取的对象：" + obj4);
		obj4.getList();
	}

	public void refXmlServiceByGridge() {
		IXmlService obj = refXmlServiceByGridge.getByGridge();
		System.out.println(refMethodInXmlService + " 这是演示如何通过xml服务引用桥：" + obj);
	}

	public void testMyJsonService() {
		System.out.println(myJsonService + " 这是演示调用test方法");
		myJsonService.test();
	}

	public void testMyAnnoService() {
		myAnnoService.createMyService("xx", new Object());
		AnnoObject ao = MyAnnoService.createStaticMyService("fuck");
		System.out.println(ao);
		IAnnoService ms = MyAnnoService.get();
		System.out.println(ms);
		
		testMixutureService();
	}

	private void testMixutureService() {
		// TODO Auto-generated method stub
		System.out.println("-----混合服务"+mixutureService);
		ITestJss jss=mixutureService.getTestJss();
		jss.printHello("fuck");
		Object obj=site.getService("$.cj.jss.test.JssPrinterNoInterface");
		ScriptObjectMirror m=(ScriptObjectMirror)obj;
		if(m.hasMember("doit")){
			m.callMember("doit", "xxxx");
		}
		Object obj2=site.getService("$.cj.jss.test.JssPrinterMultiton");
		Object obj3=site.getService("$.cj.jss.test.JssPrinterMultiton");
		Object obj4=site.getService("$.cj.jss.test.JssPrinterSingleon");
		Object obj5=site.getService("$.cj.jss.test.JssPrinterSingleon");
		
		IJssPage jp=(IJssPage)site.getService("$.cj.jss.test.JssForHtml");
		Frame frame=new Frame("get /test/ http/1.1");
		Circuit circuit=new Circuit("http/1.1 200 ok");
		jp.doPage(frame, circuit);
		System.out.println("-----处理html文档结果："+new String(circuit.content().readFully()));
	}
}
