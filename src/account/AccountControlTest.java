package account;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class AccountControlTest {
	
	@Test
	public void testAddAccount() {
		ArrayList<BankAccount> accList = new ArrayList<BankAccount>();
		accList=new AccountControl().addAccount(new AccountControl().getAccNo(accList),1,2333,101,accList);
		assertEquals("Errory", accList.get(0).getAccNo(), 100001);
	}

	@Test
	public void testDeleteAccount() {
		ArrayList<BankAccount> accList = new ArrayList<BankAccount>();
		accList=new AccountControl().addAccount(new AccountControl().getAccNo(accList),1,2333,101,accList);		
		accList=new AccountControl().deleteAccount(100001, accList);
		assertEquals("Errory", accList.size(), 0);
	}

	@Test
	public void testDeposit() {
		ArrayList<BankAccount> accList = new ArrayList<BankAccount>();
		accList=new AccountControl().addAccount(new AccountControl().getAccNo(accList),1,2333,101,accList);
		new AccountControl().deposit(100001, 100,accList);
		int j=(int) (accList.get(0).getBalance());
		assertEquals("Errory", j, 100);
	}

	@Test
	public void testSuspend() {
		ArrayList<BankAccount> accList = new ArrayList<BankAccount>();
		accList=new AccountControl().addAccount(new AccountControl().getAccNo(accList),1,2333,101,accList);
		accList=new AccountControl().suspend(100001,accList);
		assertEquals("Errory",accList.get(0).isSus, true);
	}

	@Test
	public void testWithdraw() {
		ArrayList<BankAccount> accList = new ArrayList<BankAccount>();
		accList=new AccountControl().addAccount(new AccountControl().getAccNo(accList),1,2333,101,accList);
		new AccountControl().deposit(100001, 100,accList);
		new AccountControl().withdraw(100001,2333,100,accList);
		int j=(int) (accList.get(0).getBalance());
		assertEquals("Errory", j, 0);
	}

}
