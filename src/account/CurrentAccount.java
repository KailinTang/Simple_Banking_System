package account;

public class CurrentAccount extends BankAccount { 
	//A subclass of BankAccount
	public CurrentAccount() {	//Inherited constructor
		super();
	}
	public CurrentAccount(int accNo, int PIN, int accTyp, int ID) {
		super(accNo, PIN, accTyp, ID);
	}

	public void withdraw(double amount) { 	//Overridden method
		if ((balance - amount) >= -odl) { 
			balance = balance - amount;
			System.out.println("Withdraw successfull balance="+balance);
			} else { 
				System.out.println("Withdraw unsuccessfull " + this.getAccNo()+" has a overdraft limit " + this.getOverdraftLimit()); 
				} 
			} 
}
