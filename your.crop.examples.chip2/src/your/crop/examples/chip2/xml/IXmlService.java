package your.crop.examples.chip2.xml;

import java.util.List;
import java.util.Map;

import your.crop.examples.chip2.json.IJsonService;
import your.crop.examples.chip2.json.ITest;

public interface IXmlService {

	Object getIocByMyValueParser();

	ITest getService();

	Map<Object, Object> getMap();

	String getName();

	List<Object> getList();

	//演示非静态方法，静态非静态都一样的
	IJsonService newService();

}