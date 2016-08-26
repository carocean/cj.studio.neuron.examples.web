package your.crop.examples.chip2.anno;

import cj.studio.ecm.adapter.IAdaptable;
import cj.studio.ecm.adapter.IPrototype;
import cj.studio.ecm.annotation.CjJoinpoint;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.bridge.IBridge;
import cj.studio.ecm.bridge.UseBridgeMode;
import your.crop.examples.chip2.json.IJsonService;
import your.crop.examples.chip2.json.ITest;
import your.crop.examples.chip2.xml.IXmlService;

@CjService(name = "refMethodInXmlService")
public class RefMethodInXmlService {
	@CjServiceRef(refByName = "myXmlService", refByMethod = "newService2")
	IJsonService myjsonService;

	@CjServiceRef(refByName = "myXmlService", refByMethod = "newXmlService")
	IXmlService myXmlService;

	@CjServiceRef(refByName = "myXmlService", useBridge = UseBridgeMode.forbidden)
	IXmlService myXmlServiceByBridgeForbidden;
	@CjServiceRef(refByName = "myXmlService", useBridge = UseBridgeMode.normal)
	IXmlService myXmlServiceByBridgeNormal;
	// useBridge仅在refByName时才有效，对于方法或按类型的桥接，它默认按桥接目标的配置
	@CjJoinpoint(aspects = "-myAspect1")
	@CjServiceRef(refByName = "myXmlService", useBridge = UseBridgeMode.auto)
	IXmlService xmlServiceWithPrivateAspectSet;// 具有私有方面设置的

	public IXmlService getXmlServiceWithPrivateAspectSet() {
		return xmlServiceWithPrivateAspectSet;
	}

	public IJsonService getMyjsonService() {
		return myjsonService;
	}

	public IXmlService getMyXmlService() {
		return myXmlService;
	}

	public IXmlService getMyXmlServiceByBridgeForbidden() {
		return myXmlServiceByBridgeForbidden;
	}

	public IXmlService getMyXmlServiceByBridgeNormal() {
		if (myXmlServiceByBridgeNormal instanceof IBridge) {
			IAdaptable service = (IAdaptable) myXmlServiceByBridgeNormal;
			//
			ITest t = (ITest) service;
			t.test1("测试桥机制-－－通过强制转换为ITest的方式");
			ITest t2 = service.getAdapter(ITest.class);
			t2.test1("测试桥机制-－－通过适配器转换为ITest的方式");
			IPrototype p = service.getAdapter(IPrototype.class);
			System.out.println("------这是适配器原型打印出的："+p.getServiceDefinitionId());
			Object o=p.unWrapper();
			System.out.println("-------这是桥服务的原型："+o);
		}
		return myXmlServiceByBridgeNormal;
	}
}
