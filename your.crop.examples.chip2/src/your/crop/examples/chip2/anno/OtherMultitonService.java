package your.crop.examples.chip2.anno;

import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.Scope;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceSite;

@CjService(name="otherMultitonService",scope=Scope.multiton)
public class OtherMultitonService {
	private String mmm;
	@CjServiceSite
	private IServiceSite site;
	public String getMmm() {
//		Object obj=site.getService("otherMultitonService");
//		System.out.println("这是请求运行时服务的描述....："+obj);
//		Object obj2=site.getService("otherMultitonService");
//		System.out.println("这是请求运行时服务的描述....："+obj2);
		System.out.println("这是测试运行时服务...."+site.getService("myObject"));
		System.out.println("这是测试运行时服务...."+site.getService("myObject"));
		return mmm+"dddddd";
	}
	public void setMmm(String mmm) {
		site.addService("runtime", new AnnoObject2());
		this.mmm = mmm;
	}
}