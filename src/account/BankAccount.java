package account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class BankAccount { 
	protected int accNo;	//Account number
	protected double balance;	//Account balance
	protected double odl;	//Account overdraft limit
	protected int PIN;		//Account PIN
	protected boolean isSus;	//Whether this account is suspend
	protected boolean isAct;	//Whether this account is active
	protected boolean noticeN;
	protected int accTyp;	//Account type which is 1(Current), 2(Saver) or 3(Junior)
	protected int ID;	//Connection between user ID
	
	public BankAccount(int accNo,int PIN,int accTyp,int ID) { 
		this.accNo = accNo; 
		this.balance = 0.0;
		this.odl=0;
		this.PIN=PIN;
		this.isSus=false;
		this.isAct=true;
		this.noticeN=false;
		this.accTyp=accTyp;
		this.ID=ID;
		}
	public BankAccount() { 
	}
	
	public int getAccTyp() {
		return accTyp;
	}
	public void setAccTyp(int accTyp) {
		this.accTyp = accTyp;
	}
	public int getPIN() {
		return PIN;
	}
	public double getOverdraftLimit() {
	return odl;
	}
	public void setOdl(double odl) {
	this.odl = odl;
	}
	public void setPIN(int PIN) {
		this.PIN = PIN;
	}

	public boolean isSus() {
		return isSus;
	}
	public void setIsSus(boolean isSus) {
		this.isSus = isSus;
	}
	public boolean isAct() {
		return isAct;
	}
	public void setAct(boolean isAct) {
		this.isAct = isAct;
	}
	public boolean isNoticeN() {
		return noticeN;
	}
	public void setNoticeN(boolean noticeN) {
		this.noticeN = noticeN;
	}
	
	public int getAccNo() { 
	return accNo;
	}
	public void setAccNo(int accNo) { 
	this.accNo=accNo;
	}

	public double getBalance() { 
	return balance;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void deposit(double amount) {
		if(!isSus){
			balance = balance + amount;
		}
	}	
	public void withdraw(double amount) {
		if(!isSus){
			if(accTyp==1){	//check type
				if ((balance - amount) >= -odl) { 
					balance = balance - amount;
					JOptionPane.showMessageDialog(null,"Withdraw successfull balance="+balance);
				} else { 
					JOptionPane.showMessageDialog(null,"Withdraw unsuccessfull " + this.getAccNo()+" has a overdraft limit " + this.getOverdraftLimit()); 
				}  
		}
	
			if(accTyp==2){	//check type
				Date noticeDate; 
				double noticeAmount;
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/d");
				Calendar calendar = Calendar.getInstance();  
		
				try {
					noticeDate = dateFormat.parse("2016/8/11");
					calendar.setTime(noticeDate);  
			
				} catch (ParseException e) {
					e.printStackTrace();
				}  
				Calendar cal = Calendar.getInstance();
		 	
				int year = cal.get(Calendar.YEAR);
	        
				int month=cal.get(Calendar.MONTH);

				int days=cal.get(Calendar.DATE);
		
				noticeAmount=(calendar.get(Calendar.YEAR)-year)*365+(calendar.get(Calendar.MONTH)-month)*30+(calendar.get(Calendar.DATE)-days);  
		
	       if(noticeAmount==0){
	    	   if ((balance - amount) >= 0) { 
	    		   balance = balance - amount;
	    		   JOptionPane.showMessageDialog(null,"Withdraw successfull balance="+balance);
	    	   } 
	    	   else { 
				JOptionPane.showMessageDialog(null,"Withdraw unsuccessfull. Do not have enough available funds."); 
				} 
			}
	       else{	//Notice date
	    	   JOptionPane.showMessageDialog(null,"You can withdraw money after "+noticeAmount+" days");
	    	   } 
		
		}
		if(accTyp==3){		//check type
			JOptionPane.showMessageDialog(null,"You can't withdraw money in junior account");
		}
		}
		else {
			JOptionPane.showMessageDialog(null,"The account has been suspend");
		}
	}
	public void clearFunds(){
		balance=0;
	}
	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", balance=" + balance + ", odl=" + odl + ", PIN=" + PIN + ", isSus=" + isSus
				+ ", isAct=" + isAct + ", noticeN=" + noticeN + ", accTyp=" + accTyp + ", ID=" + ID +"]";
	}
	public void setBalance(double balance) {
		this.balance=balance;	
	}

}
