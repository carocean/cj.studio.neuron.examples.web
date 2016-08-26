package your.crop.examples.chip2.jss;

import cj.studio.ecm.frame.Circuit;
import cj.studio.ecm.frame.Frame;
/**
 * 感受下对网页的处理。<br>
 * 本例只是简单的向网站开发者演示下对html的修改和输出，并不真正的向浏览器输出，如果想使用网站开发的功能，请参见websiteGraph的使用说明
 * @author carocean
 *
 */
public interface IJssPage {
	void doPage(Frame frame,Circuit circuit);
}
