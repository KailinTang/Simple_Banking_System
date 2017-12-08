package customer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Guest {
	//A entity class maintain the core information of the user
	int ID;
	String name;
	String addr;
	Date dob;
	boolean creStat;
	
	public Guest(int ID,String name2, String addr2,Date dob2) {		//Instructor 
		this.ID=ID;
		this.name=name2;
		this.addr=addr2;
		this.dob=dob2;
	}
	public Guest(){
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public boolean isCreStat() {
		return creStat;
	}
	public void setCreStat(boolean creStat) {
		this.creStat = creStat;
	}
	@Override
	public String toString() {
		Calendar calendar = Calendar.getInstance();   
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/d");  
		  calendar.setTime(dob);  
		  String str = (dateFormat.format(calendar.getTime()));   

		return "Guest [ID=" + ID + ", name=" + name + ", addr=" + addr + ", dob=" + str + ", creStat=" + creStat + "]";
	}
	
	
}
