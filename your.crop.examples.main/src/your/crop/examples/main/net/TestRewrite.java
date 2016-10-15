package your.crop.examples.main.net;

public class TestRewrite {

	public static void main(String[] args) {
		// 上下文要重写 /?swsid=2323不用重写 /dd?swsid=32323要重写 /dd 要重写
		String str = "/e?swsid=32323&s=3";
		int secondpos = str.indexOf("/", 1);
		if (str.length()!=1&&!str.startsWith("/?")&&secondpos == -1) {
			System.out.println("matched");
			String cpath = "";
			String q="";
			int qpos = str.indexOf("?", 1);
			if (qpos > -1) {
				cpath = str.substring(1, qpos);
				q=str.substring(qpos,str.length());
			} else {
				cpath = str.substring(1, str.length());
			}
			if(!"".equals(cpath)&&cpath.indexOf(".")==-1){
				int jhpos=cpath.lastIndexOf("#");
				String jh="";
				if(jhpos>-1){
					jh=cpath.substring(jhpos,cpath.length());
					cpath=cpath.substring(0, jhpos);
				}
				String rerul=String.format("/%s%s/%s", cpath,jh,q);
				System.out.println("需重写");
				System.out.println(rerul);
			}
		}
	}

}
