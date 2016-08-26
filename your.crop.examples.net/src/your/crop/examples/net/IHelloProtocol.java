package your.crop.examples.net;

import cj.studio.ecm.graph.CjStatusDef;
import cj.studio.ecm.graph.IConstans;

public interface IHelloProtocol extends IConstans{
	@CjStatusDef(message = "HLWD/1.0")
	String PROTOCAL = "protocol";
}
