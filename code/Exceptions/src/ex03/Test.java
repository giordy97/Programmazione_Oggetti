package ex03;

public class Test {
	public void f() throws myExcp02 {
		try {
			g();
		} catch (myExcp01 e) {
			throw new myExcp02();
		}
	}
	
	public void g() throws myExcp01 {
		throw new myExcp01();
	}

}
