package your.crop.examples.chip2.json;

import java.util.List;
import java.util.Map;

import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.adapter.IActuator;
import cj.studio.ecm.adapter.IAdaptable;

public class MyJsonService implements IJsonService {
	private Object byBridge;
	private Object deptment;
	IServiceSite site;
	List<Object> list;
	Map<String,Object> map;
	Object iocByMyValueParser;
	Object byMethod2;
	Object byMethod1;
	public MyJsonService() {
		// TODO Auto-generated constructor stub
	}
	public MyJsonService(int t,IMyJsonBridge b) {
		System.out.println("----这是json service构造:"+t+"  "+b);
	}
	public void test() {
		IAdaptable a = (IAdaptable) deptment;
		IActuator act = a.getAdapter(IActuator.class);
		Object result = act.exeCommand("getUserId", "我吊");
		System.out.println("deptment.getUserId.." + result);
		System.out.println("----"+byBridge+" 这是演示json服务调用桥服务");
		Object obj=newService();
		System.out.println(obj);
	}

	public static IMyJsonBridge newService() {
		return new MyJsonBridge();
	}

	/* (non-Javadoc)
	 * @see your.crop.examples.chip2.json.IJsonService#newService(java.lang.String)
	 */
	@Override
	public Object newService(String tt) {
		return new MyJsonBridge();
	}

}
