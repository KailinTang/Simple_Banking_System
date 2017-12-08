package account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SaverAccount extends BankAccount{
 
	private Date noticeDate; 
	private double noticeAmount;
	public void withdraw(double amount) {	//Overridden method
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/d");
		Calendar calendar = Calendar.getInstance();  
		
		try {
			noticeDate = dateFormat.parse("2016/5/12");
			calendar.setTime(noticeDate);  
			
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		 Calendar cal = Calendar.getInstance();
		 	
	        int year = cal.get(Calendar.YEAR);
	        
	        int month=cal.get(Calendar.MONTH);

	        int days=cal.get(Calendar.DATE);
		
	       noticeAmount=(calendar.get(Calendar.YEAR)-year)*365+(calendar.get(Calendar.MONTH)-month)*30+(calendar.get(Calendar.DATE)-days);  
		
		if(noticeAmount==0){	//Notice amount equal to 0 means that you can immediate withdraw money
		if ((balance - amount) >= 0) { 
			balance = balance - amount;
			System.out.println("Withdraw successfull balance="+balance);
			} else { 
				System.out.println("Withdraw unsuccessfull. Do not have enough available funds."); 
				} 
			}
		else{	//You can not withdraw money immediately
			System.out.println("You can withdraw money after "+noticeAmount+" days");
			} 
		}
	
	
}
