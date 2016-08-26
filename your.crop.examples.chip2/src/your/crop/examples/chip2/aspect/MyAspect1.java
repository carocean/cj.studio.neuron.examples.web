package your.crop.examples.chip2.aspect;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.bridge.IAspect;
import cj.studio.ecm.bridge.ICutpoint;
import your.crop.examples.chip2.json.ITest;
@CjService(name="myAspect1")
public class MyAspect1 implements IAspect {

	@Override
	public Object cut(Object bridge, Object[] args, ICutpoint point) {
		point.getServiceDefId();
		point.getMethodName();
		point.getMethodDesc();
		System.out.println(String.format("－－－%s方面拦截执行方法：%s.%s%s",this,point.getServiceDefId(),point.getMethodName(),point.getMethodDesc()));
		return point.cut(bridge, args);
	}
	@Override
	public Class<?>[] getCutInterfaces() {
		// TODO Auto-generated method stub
		return new Class<?>[]{ITest.class,IA.class};
	}

}
