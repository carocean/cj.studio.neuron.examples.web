package your.crop.examples.chip2.json;

import cj.studio.ecm.IServiceSetter;

public class MyJsonBridge implements IServiceSetter, IMyJsonBridge{
	String prop1;
	JsonObject jo;
	/* (non-Javadoc)
	 * @see your.crop.examples.chip2.json.IMyJsonBridge#getProp1()
	 */
	@Override
	public String getProp1() {
		return prop1;
	}
	@Override
	public void setService(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println(this+"这是演示json返注入");
	}
}
