package ex02;

public class MyException extends Exception {
	private static final long serialVersionUID = 1L;
	protected String myStr;

	public MyException(String myStr) {
		super();
		this.myStr = myStr;
	}
	
	public String getMyString() {
		return myStr;
	}
}
