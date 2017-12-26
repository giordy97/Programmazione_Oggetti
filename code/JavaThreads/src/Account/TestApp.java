package Account;

public class TestApp { 
	public static void main (String [] args) {
		Account account = new Account(150);
		Thread homer = new Thread(new Person(account), "Homer");  
		Thread marge = new Thread(new Person(account), "Marge");
		homer.start();
		marge.start();
	}
}
