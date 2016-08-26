package your.crop.examples.chip2.anno;

import cj.studio.ecm.IServiceSetter;
import cj.studio.ecm.Scope;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;

@CjService(name="annoObject",scope=Scope.singleon)
public class AnnoObject implements IServiceSetter{
	@CjServiceRef(refByName="annoObject2")
	AnnoObject2 obj;
	
	Object owner;
	@Override
	public void setService(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		this.owner=arg1;
	}
}
