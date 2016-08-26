package your.crop.examples.chip2.valueparser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cj.studio.ecm.IServiceProvider;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.parser.ValueParser;
import cj.ultimate.util.StringUtil;
/**
 * 演示自定义一个属性值解析器<br>
 * 该例创建一个对象
 * @author carocean
 *
 */
@CjService(name = "my.objectParser")
public class MyObjectValueParser extends ValueParser {
	Pattern p = Pattern.compile("^new (.+)\\(\\);$", Pattern.DOTALL);
	@Override
	public Object parse(String propName, String value,
			Class<?> targetType, IServiceProvider provider) {
		Matcher m = p.matcher(value);
		boolean yesorno = m.matches();
		if (yesorno) {
			String type = m.group(1);
			if (!StringUtil.isEmpty(type)) {
				Class<?> clazz;
				try {
					clazz = Class.forName(type);
					return clazz.newInstance();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		return super.parse(propName, value, targetType, provider);
	}
}
