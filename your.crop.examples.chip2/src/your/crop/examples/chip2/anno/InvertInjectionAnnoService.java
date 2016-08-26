package your.crop.examples.chip2.anno;

import cj.studio.ecm.IServiceSetter;
import cj.studio.ecm.annotation.CjService;

@CjService(name = "invertInjectionAnnoService")
public class InvertInjectionAnnoService implements IServiceSetter {
	@Override
	public void setService(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println(this+"-----这是强制返向注入服务：" + arg0);
	}
}
