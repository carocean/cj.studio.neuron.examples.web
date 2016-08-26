package your.crop.examples.chip2.anno;

import java.util.List;
import java.util.Map;

import cj.studio.ecm.IServiceAfter;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.ServiceCollection;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjJoinpoint;
import cj.studio.ecm.annotation.CjMethod;
import cj.studio.ecm.annotation.CjMethodArg;
import cj.studio.ecm.annotation.CjPropertyValue;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceInvertInjection;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.bridge.UseBridgeMode;

@CjBridge(aspects = "myAspect1+$.cj.jss.test.JssMyAspect")
@CjService(name = "myAnnoService", constructor = "newMyAnnotation")
public class MyAnnoService implements IServiceAfter, IAnnoService {
	@CjServiceRef(refByType = AnnoObject.class)
	ServiceCollection<AnnoObject> objs;
	@CjServiceInvertInjection()
	@CjServiceRef(refByType = AnnoObject.class)
	AnnoObject obj;
	private int mmm;
	private String contrustText;
	@CjServiceRef(refByName = "myAnnoService", useBridge = UseBridgeMode.forbidden)
	static MyAnnoService the;
	@CjJoinpoint(aspects="myAspect3")
	@CjServiceRef(refByName = "myAnnoService",useBridge=UseBridgeMode.auto)
	static IAnnoService the2;
	@CjServiceSite
	IServiceSite site;
	
	@CjServiceRef(refByMethod="createMyService")
	AnnoObject byMethod;
	
	@CjServiceRef(refByMethod="createStaticMyService")
	AnnoObject byMethod2;
	
	@CjServiceRef(refByMethod="factory",useBridge=UseBridgeMode.forbidden)
	MyAnnoService byMethod3;
	
	@CjPropertyValue(parser = "cj.jsonMap", value = "{'age1':'333','myObject':'$.annoObject'}")
	private Map<String, Object> map;

	@CjPropertyValue(parser = "cj.jsonList", value = "['333','$.annoObject']")
	private List<Object> List;
	@CjServiceRef(refByName="otherMultitonService")
	OtherMultitonService multition;
	@CjMethod(alias = "newMyAnnotationMMM")
	public MyAnnoService(@CjMethodArg(value = "44") int mmm) {
		this.mmm = mmm;
	}

	@CjMethod(alias = "newMyAnnotation")
	public MyAnnoService(@CjMethodArg(value = "这是构造注入的TTTT的值") String tttt) {
		contrustText = tttt;
		System.out.println("这是构造输出：" + tttt);
	}

	@CjMethod(alias = "factory")
	public static MyAnnoService get() {
		return the;
	}

	@CjMethod(alias = "createMyService", returnDefinitionId = "annoObject")
	public AnnoObject createMyService(@CjMethodArg(value = "ddfddfas") String text,
			@CjMethodArg(ref = "annoObject") Object service) {
		System.out.println("这是方法参数注入的对象：" + service);
		System.out.println("这是方法参数注入的值：" + text);
		AnnoObject o = new AnnoObject();
		return o;
	}

	@CjMethod(alias = "createStaticMyService", returnDefinitionType = ".")
	public static AnnoObject createStaticMyService(@CjMethodArg(value="tttt")String text) {
		AnnoObject o = new AnnoObject();
		return o;
	}

	@Override
	public void onAfter(IServiceSite site) {
		// TODO Auto-generated method stub
		System.out.println(site);
		the2.toString();
		multition.setMmm("xxx");
		System.out.println("----多例："+multition);
		Object o=site.getService("otherMultitonService");
		System.out.println("----多例："+o);
		Object o2=site.getService("otherMultitonService");
		System.out.println("----多例："+o2);
		System.out.println("----运行时服务："+site.getService("runtime"));
	}

}
