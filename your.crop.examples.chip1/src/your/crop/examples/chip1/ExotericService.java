package your.crop.examples.chip1;

import cj.studio.ecm.IExotericServiceFinder;
import cj.studio.ecm.IServiceProvider;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.ServiceCollection;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceSite;
import your.crop.examples.chip1.external.IDeptmemt;

@CjService(name = "exotericService",isExoteric=true)
public class ExotericService  {
	@CjServiceSite
	IServiceSite site;
	/**
	 * 测试从chip2中调用IDeptmemt接口的实现，如果chip2调用了chip2.dependency(chip1);
	 */
	public void testFindExotericServiceInOtherChip() {
		IExotericServiceFinder finder = (IExotericServiceFinder) site
				.getService(IExotericServiceFinder.class.getName());
		IServiceProvider sp= finder.getLocalExotericServiceProvider();
		//搜本芯片内的实现
		IDeptmemt dept=(IDeptmemt)sp.getService("deptment");
		//搜子芯片的实现
		ServiceCollection<IDeptmemt> col=finder.getExotericServices(IDeptmemt.class);
		System.out.println(col.size());
		if(col.size()>0){
			IDeptmemt d=col.get(0);
			System.out.println(d.getUserId("dddd").getUserName());
		}
	}
}
