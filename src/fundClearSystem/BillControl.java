package fundClearSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class BillControl {
	public ArrayList<Bill> addBill(int accNo,int amount,ArrayList<Bill> billList){
		Bill bill=new Bill(accNo,amount);	
		billList.add(bill);		
		return billList;
	}
	public void clearFund(){
		ArrayList<Bill> billList = new ArrayList<Bill>();		
		CsvOutstandingBill t = new CsvOutstandingBill();
		billList=t.readCsv();		
		billList.clear();
		t.writeCsv(billList);
	}	
	public void clearFundPeriodically(){
		Calendar cal = Calendar.getInstance();  
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date clearTime=new Date();		
		try {
			clearTime=dateFormat.parse("22:41");
			cal.setTime(clearTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		
		while(true){
		Calendar calendar = Calendar.getInstance();  
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
		String str = (dateFormat2.format(calendar.getTime()));
		System.out.println(str);
		int curHour = calendar.get(Calendar.HOUR);
		int curMinute = calendar.get(Calendar.MINUTE);
		if((hour==curHour)&&(minute==curMinute)){
			new BillControl().clearFund();
			break;
		}
		try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}		
	}
}
