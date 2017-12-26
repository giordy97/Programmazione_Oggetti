package Bank;

public class TestApp {
	public static void main(String[] args) {
		SavingsAccount momsSavings = new SavingsAccount(0.5);
		CheckingAccount harrysChecking = new CheckingAccount(100);
		
		momsSavings.deposit(10000);
		momsSavings.transfer(2000, harrysChecking);
		
		harrysChecking.withdraw(1500);
		harrysChecking.withdraw(80);
		
		momsSavings.addInterest();
		harrysChecking.deductFees();

		System.out.println("Mom's savings balance = $"
				+ momsSavings.getBalance());

		System.out.println("Harry's checking balance = $"
				+ harrysChecking.getBalance());
	}
}