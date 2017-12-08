package customer;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class GuestControl {
	public ArrayList<Guest> addGuest(Guest guest,ArrayList<Guest> guestList){
		//Add a new guest
		checkUser cU = new checkUser();
		boolean writeAble= cU.checkGuest(guest);
		if(guest.creStat){
			for(int row=0;row<guestList.size();row++){			
			Guest  cell = guestList.get(row);
				if(cell.ID==guest.ID){
				System.out.println("the userID can not be the same");
				writeAble=false;
				break;				
				}
			}
		}else System.out.println("User credit is not enough");
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		Calendar cal1= Calendar.getInstance();
		cal1.setTime(guest.dob);
		int chazhi=year-cal1.get(Calendar.YEAR);
		if(chazhi<0){
			writeAble=false;
			JOptionPane.showMessageDialog(null,"The date of birth must < current date");
		}
		if(writeAble){
		guestList.add(guest);
		}
		return guestList;
	}
	public ArrayList<Guest> deleteGuest(int ID,ArrayList<Guest> guestList){	
		//Remove the guest from the system
		for (int i=0;i<guestList.size();i++) {		
			   if(guestList.get(i).ID==ID){
				   guestList.remove(i);
				   System.out.println("deleted successfully"+ID);
				   break;
			   }
			   if(i==guestList.size()-1) System.out.println("Can't find the guest.");  
		}		
		return guestList;
	}

}



