package your.crop.examples.chip2.xml;

import java.util.List;
import java.util.Map;

import cj.studio.ecm.IServiceAfter;
import cj.studio.ecm.IServiceSite;
import your.crop.examples.chip2.anno.InvertInjectionAnnoService;
import your.crop.examples.chip2.json.IJsonService;
import your.crop.examples.chip2.json.ITest;
import your.crop.examples.chip2.json.MyJsonService;

public class MyXmlService implements IServiceAfter,ITest/*在服务容器初始化后触发*/, IXmlService{
	private String name;
	private Map<Object, Object> map;
	List<Object >list;
	ITest service;
	IJsonService service2;
	IJsonService service3;
	InvertInjectionAnnoService invertInjectionAnnoService;
	Object	iocByMyValueParser;
	IServiceSite site;
	public MyXmlService() {
		// TODO Auto-generated constructor stub
	}
	public MyXmlService(int v) {
		System.out.println(this+" 这是构造注入："+v);
	}
	@Override
	public void onAfter(IServiceSite arg0) {
		System.out.println("MyXmlService .... 服务容器执行后被触发");
	}
	public void test1(String n) {
		System.out.println("MyXmlService ....演示不必实现ITest接口，只在myaspect1中切入接口即可执行myxmlService.test方法："+n);
	}
	/* (non-Javadoc)
	 * @see your.crop.examples.chip2.xml.IXmlService#getIocByMyValueParser()
	 */
	@Override
	public Object getIocByMyValueParser() {
		return iocByMyValueParser;
	}
	/* (non-Javadoc)
	 * @see your.crop.examples.chip2.xml.IXmlService#getService()
	 */
	@Override
	public ITest getService() {
		return service;
	}
	/* (non-Javadoc)
	 * @see your.crop.examples.chip2.xml.IXmlService#getMap()
	 */
	@Override
	public Map<Object, Object> getMap() {
		return map;
	}
	/* (non-Javadoc)
	 * @see your.crop.examples.chip2.xml.IXmlService#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see your.crop.examples.chip2.xml.IXmlService#getList()
	 */
	@Override
	public List<Object> getList() {
		return list;
	}
	/**
	 * 只能通过属性引用到它时，参数是声明的参数，当直接调用时，参数是调用时指定的参数，但返回的服务的处理是一致的
	 * @param tt
	 * @param mm
	 * @param obj
	 * @return
	 */
	public static Object newService(String tt,String mm,MyJsonService obj) {
		return new MyJsonService();
	}
	//演示非静态方法，静态非静态都一样的
	/* (non-Javadoc)
	 * @see your.crop.examples.chip2.xml.IXmlService#newService()
	 */
	@Override
	public IJsonService newService() {
		return new MyJsonService();
	}
}
