package fundClearSystem;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BillControlTest {

	@Test
	public void testAddBill() {
		ArrayList<Bill> billList = new ArrayList<Bill>();
		billList=new BillControl().addBill(100005,123 ,billList);
		assertEquals("Error", billList.size(),1);
	}

}
