//定义导出包，该包路径下的public类型可被依赖它的程序集访问
/*
 * 开放类型的三种方法：
 * 1.在Assembly.json中声明开放的包
 * 2.通过package-info.java文件声明开放的包
 * 3.指定某个类型开放，即在类名前加@CjExotericalType,当然使用xml,json来注解是一样的
 */
@CjExotericalType
package your.crop.examples.chip1.external;
import cj.studio.ecm.annotation.CjExotericalType;
//此文件中只支持友好类，即可在包路径下可见，但对程序集不可见
//这里是包类，声明一个包使用的公共类，强调的是包访问权限
class PkgClass{
	public void test(){
	}
}
//包常量，只运行包内访问，适用于分“包”开发
class PkgConst{
	static final String PACAKGE_CONST="ABC";
}