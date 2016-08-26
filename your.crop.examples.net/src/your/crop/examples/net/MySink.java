package your.crop.examples.net;

import cj.studio.ecm.frame.Circuit;
import cj.studio.ecm.frame.Frame;
import cj.studio.ecm.graph.CircuitException;
import cj.studio.ecm.graph.IPlug;
import cj.studio.ecm.graph.ISink;

public class MySink implements ISink {
		@Override
		public void flow(Frame frame,Circuit circuit, IPlug plug) throws CircuitException {
			System.out.println("--------------hello world!-----------");
			System.out.println(frame);
			System.out.println("--------------end!-----------");
		}
	}