package account;
import java.util.Comparator;

public class SortByID implements Comparator<Object> {
	//Implement the function of compare the ID of two object to realize sort
		 public int compare(Object o1, Object o2) {
		  BankAccount s1 = (BankAccount) o1;
		  BankAccount s2 = (BankAccount) o2;
		  if (s1.getAccNo() > s2.getAccNo())
		   return 1;
		  else if (s1.getAccNo() == s2.getAccNo()) {
		   return 0;
		  }
		  return -1;
		 }
		
}
	
	
