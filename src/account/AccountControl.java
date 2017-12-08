package account;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class AccountControl {
	public ArrayList<BankAccount> addAccount(int accNo,int accTyp,int PIN,int ID,ArrayList<BankAccount> accountList){		
		//Add a new account
		BankAccount account=new BankAccount(accNo,PIN,accTyp,ID);	//An instance of a bank account
		accountList.add(account);	//Add the account to the account list
		Collections.sort(accountList, new SortByID());	//sort by ID
		 for (BankAccount account1 : accountList) {
			   System.out.println(account1.accNo + " / " + account1.balance);
			  }
		return accountList;
	}
	public ArrayList<BankAccount> deleteAccount(int ID,ArrayList<BankAccount> accList){
		//Delete a specific account
		for (int i=0;i<accList.size();i++) {		
			   if(accList.get(i).accNo==ID){
				   if(accList.get(i).balance==0){	//Check whether there are money in that account 
						   accList.remove(i);	//Remove from the arrayList
						   JOptionPane.showMessageDialog(null,"Deleted successfully");
				   }else{
					   JOptionPane.showMessageDialog(null,"Please withdraw all money before close account");
				   }
				   break;
			   }
			   if(i==accList.size()-1){
				   System.out.println("Can't find the account.");  
			   }
		}		
		return accList;
	}
	
	public ArrayList<BankAccount> deposit(int accNo,int money,ArrayList<BankAccount> accList){
	//Deposit money to that bank account
		for (int i=0;i<accList.size();i++) {		
			   if(accList.get(i).accNo==accNo){
				   if(!accList.get(i).isSus()){		//Check whether the bank account is suspended
					   accList.get(i).deposit(money);	//Deposit money to that account
					   JOptionPane.showMessageDialog(null, "Deposit "+money+" to "+accList.get(i).accNo+" now the balance is "+accList.get(i).balance);
				   } else{
					   JOptionPane.showMessageDialog(null, "the ID has been suspended.");
				   }
				   break;
			   }
			   if(i==accList.size()-1){
				   System.out.println("Can't find the account.");  
			   }
		}
		return accList;
	}
	
	public boolean checkSuspend(int accNo,ArrayList<BankAccount> accList){
	//Check whether the bank account is suspended it will return a boolean value
		boolean result=false;
		for (int i=0;i<accList.size();i++) {		
			   if(accList.get(i).accNo==accNo){
				   result=accList.get(i).isSus;
				   break;
			   }
			   if(i==accList.size()-1){
				   System.out.println("Can't find the account.");  
			   }
		}
		return result;
	}
	
	public ArrayList<BankAccount> suspend(int accNo,ArrayList<BankAccount> accList){
		//Suspend an account
		for (int i=0;i<accList.size();i++) {		
			   if(accList.get(i).accNo==accNo){
				   if(accList.get(i).isSus){	//Not used in GUI
					   System.out.println(accList.get(i).accNo+" has been suspended.");
				   }else{
				   accList.get(i).setIsSus(true);	//Suspend the account
				   JOptionPane.showMessageDialog(null,"suspending "+accList.get(i).accNo+" successfully");
				   }
				   break;
			   }
			   if(i==accList.size()-1){
				   System.out.println("Can't find the account.");  
			   }
		}
		return accList;
	}
	
	public ArrayList<BankAccount> reInstate(int accNo,ArrayList<BankAccount> accList){
		//Recover the account
		for (int i=0;i<accList.size();i++) {		
			   if(accList.get(i).accNo==accNo){
				   if(!accList.get(i).isSus){
					   System.out.println(accList.get(i).accNo+" is available");
				   }else{
				   accList.get(i).setIsSus(false);
				   JOptionPane.showMessageDialog(null,"reinstate "+accList.get(i).accNo+" successfully");				   
				   }
				   break;
			   }
			   if(i==accList.size()-1){
				   System.out.println("Can't find the account.");  
			   }
		}
		return accList;
	}
	
	
	public int getAccNo(ArrayList<BankAccount> accList){
		//Get the account number
		int IDgre=100001;	//First initial value of account ID
		for(BankAccount account:accList){
				if(account.accNo!=IDgre){					
					break;
				}
				IDgre++;			
		}
		return IDgre;
	}
	public ArrayList<BankAccount> withdraw(int accNo,int PIN,int amount,ArrayList<BankAccount> accList){
		//Withdraw money from the account
		for(int row=0;row<accList.size();row++){
			BankAccount cell = accList.get(row);
			if(cell.getAccNo()==accNo){
				if(cell.getPIN()==PIN){
						cell.withdraw(amount);	//Withdraw money
						break;
				}else {
					JOptionPane.showMessageDialog(null,"PIN is not true");
					break;
				}
			}
			if(row==accList.size()-1){
				JOptionPane.showMessageDialog(null,"Can't find the Account.");
			}
		}
		return accList;		
	}
}
