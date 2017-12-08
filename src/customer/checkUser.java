package customer;

import java.util.ArrayList;

import credit.Credit;
import credit.CsvCre;

public class checkUser {
	public boolean checkGuest(Guest guest){
		//Check whether the credit of a guest is enough
		boolean writeAble=true;
		guest.setCreStat(confirmCreditStatus(guest.ID));		
		if(!guest.creStat){
			writeAble=false;
			System.out.println("The credit of the user is insufficient ");
		}		
		return writeAble;	
	}
	
	public boolean confirmCreditStatus(int ID){
		//Confirm the state of user credit
		boolean Creditstatue=true;
		ArrayList<Credit> creditList = new ArrayList<Credit>();
		CsvCre t = new CsvCre();
		creditList=t.readCsv();
		for(int row=0;row<creditList.size();row++){			
			Credit cell = creditList.get(row);
			if(cell.getID()==ID){
				Creditstatue=cell.isCreStat();
			break;
			}
			if(row==creditList.size()-1) System.out.println("Can't find the guest.");
		}
		return Creditstatue;
	}
}
