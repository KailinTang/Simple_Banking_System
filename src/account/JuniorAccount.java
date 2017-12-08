package account;

public class JuniorAccount extends BankAccount{

	public void withdraw(double amount) {
		System.out.println("You can't withdraw money in junior account");
	}
}
