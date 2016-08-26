package your.crop.examples.chip2.aspect;

import java.util.List;

import cj.studio.ecm.bridge.IAspect;
import cj.studio.ecm.bridge.ICutpoint;

public class MyAspect4 implements IAspect{
	private List<String> pattern;

	@Override
	public Object cut(Object bridge, Object[] args, ICutpoint point) {
		System.out.println(String.format("－－－%s方面拦截执行方法：%s.%s%s",this,point.getServiceDefId(),point.getMethodName(),point.getMethodDesc()));
		return point.cut(bridge, args);
	}

	@Override
	public Class<?>[] getCutInterfaces() {
		// TODO Auto-generated method stub
		return null;
	}

}
