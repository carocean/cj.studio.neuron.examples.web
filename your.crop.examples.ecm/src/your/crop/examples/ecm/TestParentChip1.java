package your.crop.examples.ecm;

import cj.studio.ecm.IServiceAfter;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;

@CjService(name="testParentChip1",isExoteric=true)
public class TestParentChip1 implements IServiceAfter{
	@CjServiceRef(refByName="exotericService")
	Object obj;
	public TestParentChip1() {
		
	}
	@Override
	public void onAfter(IServiceSite arg0) {
		// TODO Auto-generated method stub
		System.out.println("--chip2.parent(chip1) exotericService result:--"+obj);
	}
}
