package fundClearSystem;

public class Bill {
	int accNo;
	int amount;
	
	public Bill(int accNo, int amount) {
		this.accNo = accNo;
		this.amount = amount;
	}
	public Bill(){
		
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Bill [accNo=" + accNo + ", amount=" + amount + "]";
	}	
}
