package controlCenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import account.AccountControl;
import account.BankAccount;
import account.CsvAcc;
import customer.CsvGuest;
import customer.Guest;
import customer.GuestControl;
import fundClearSystem.Bill;
import fundClearSystem.BillControl;
import fundClearSystem.CsvOutstandingBill;

public class controller {

	private ArrayList<Bill> billList =new ArrayList<Bill>();
	private ArrayList<Guest> guestList=new ArrayList<Guest>();
	private ArrayList<BankAccount> accList = new ArrayList<BankAccount>(); 
	void SystemLoad(){	
		//Load all useful table to the system
		CsvAcc t1 = new CsvAcc();
		accList=t1.readCsv();
		CsvOutstandingBill t2 = new CsvOutstandingBill();
		billList=t2.readCsv();
		CsvGuest t4 = new CsvGuest();
		guestList=t4.readCsv();
		new threadClearSystem().start();
		
	}
	public void systemsave(){	
		//Store the value when you close the software
		CsvAcc t1 = new CsvAcc();
		t1.writeCsv(accList);
		CsvOutstandingBill t2 = new CsvOutstandingBill();
		t2.writeCsv(billList);
		CsvGuest t4 = new CsvGuest();
		t4.writeCsv(guestList);
	}
	public void addGuest(int ID, String name, String address, String dob) {
		//Add a guest to the system
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/d");
		Date dob1=new Date();
		try {
			dob1 = dateFormat.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Guest guest=new Guest(ID,name,address,dob1);
		guestList=new GuestControl().addGuest(guest, guestList);
	}
	
	public void deleteGuest(String ID){
		String[] aa;
		aa=ID.split(" ");	
		guestList=new GuestControl().deleteGuest(Integer.parseInt(aa[0]), guestList);
	}
	
	public void createAccount(int ID,int PIN,int accTyp){
		if(PIN<=9999&&PIN>=0){											
		for(int row=0;row<guestList.size();row++){						
		Guest  cell = guestList.get(row);
			if(cell.getID()==ID){				
				if(accTyp==3){											
					Calendar cal = Calendar.getInstance();
					int year = cal.get(Calendar.YEAR);
					cal.setTime(cell.getDob());
					int chazhi=year-cal.get(Calendar.YEAR);
					if(chazhi>16) {
						JOptionPane.showMessageDialog(null, "Only customers under the age of 16 may open a Junior account"); 
						System.out.println("Only customers under the age of 16 may open a Junior account"+chazhi);
						break;
					}
				}			
				int accNo = new AccountControl().getAccNo(accList);
				accList = new AccountControl().addAccount(accNo,accTyp,PIN,ID,accList);
			break;				
			}
			if(row==guestList.size()-1){
				System.out.println("Can't find the guest.");
			}
		}
		} else JOptionPane.showMessageDialog(null,"PIN must less than 9999 and bigger than 0");	
	}
	public boolean checkID(int ID){
		boolean x=false;
		for (int i=0;i<guestList.size();i++) {		
			   if(guestList.get(i).getID()==ID){
				   x=true;
				   break;
			   }
			   if(i==guestList.size()-1) JOptionPane.showMessageDialog(null, "The ID Does not exist");  
		}
		return x;
	}
	
	public boolean checkAcc(int accNo,int PIN){
		boolean x=false;
		for(int row=0;row<accList.size();row++){
			BankAccount cell = accList.get(row);
			if(cell.getAccNo()==accNo){
				if(cell.getPIN()==PIN){
						x=true;
						break;
				}else {
					JOptionPane.showMessageDialog(null,"PIN is not true");
					break;
				}
			}
			if(row==accList.size()-1) JOptionPane.showMessageDialog(null,"Can't find the Account.");
		}
		return x;
	}
	public void deposit(String ID,int amount){
		String[] aa;
		aa=ID.split(" ");	
		accList=new AccountControl().deposit(Integer.parseInt(aa[0]), amount,accList);
	}
	public void depositUnclear(String ID,int amount){
		String[] aa;
		aa=ID.split(" ");
		billList=new BillControl().addBill(Integer.parseInt(aa[0]),amount,billList);
	}
	
	public void clearFund(){
		JOptionPane.showMessageDialog(null,"It's time to clear fund"); 
		for(Bill bill1 : billList){			
			deposit(bill1.getAccNo()+" ", bill1.getAmount());			
		}
		billList.clear();
	}
	public void suspend(String ID){
		String[] aa;
		aa=ID.split(" ");
		accList=new AccountControl().suspend(Integer.parseInt(aa[0]),accList);
	}
	public void reinstate(String ID){
		String[] aa;
		aa=ID.split(" ");
		accList=new AccountControl().reInstate(Integer.parseInt(aa[0]),accList);
	}
	public void closeAccount(String ID){
		String[] aa;
		aa=ID.split(" ");
		accList=new AccountControl().deleteAccount(Integer.parseInt(aa[0]), accList);
	}
	public void withdraw(int accNo,int PIN,int amount){
		accList=new AccountControl().withdraw(accNo,PIN,amount,accList);
	}	
	public class threadClearSystem extends Thread{
		//Periodically update the fund
		public void run(){
		Calendar cal = Calendar.getInstance(); 	//Get the system time
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date clearTime=new Date();		
		try {
			clearTime=dateFormat.parse("23:18");	//Casting to time format
			cal.setTime(clearTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		
		while(true){
		Calendar calendar = Calendar.getInstance();  
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
		String str = (dateFormat2.format(calendar.getTime()));
		System.out.println(str);	//Constantly show the time
		int curHour = calendar.get(Calendar.HOUR);
		int curMinute = calendar.get(Calendar.MINUTE);
		if((hour==curHour)&&(minute==curMinute)){	//Check whether it is time to clear fund
			clearFund();
			break;
		}
		try {
			Thread.sleep(1000);		//Delay 1 second
			} 
		catch (InterruptedException e) {
			e.printStackTrace();
				}
			}		
		}
	}
	
	public boolean checkDebts(){
		//Check debt when close the system
		boolean closeAble=true;
		for (BankAccount bankAcc:accList) {		
			   if(bankAcc.getBalance()<0){
				   closeAble=false;
				   JOptionPane.showMessageDialog(null, "The user : "+bankAcc.getID()+" has debt.");
				   break;
			   } 
		}
		return closeAble;
	}
	
	public ArrayList<Bill> getBillList() {
		return billList;
	}
	public void setBillList(ArrayList<Bill> billList) {
		this.billList = billList;
	}
	public ArrayList<Guest> getGuestList() {
		return guestList;
	}
	public void setGuestList(ArrayList<Guest> guestList) {
		this.guestList = guestList;
	}
	public ArrayList<BankAccount> getAccList() {
		return accList;
	}
	public void setAccList(ArrayList<BankAccount> accList) {
		this.accList = accList;
	}
	
}
