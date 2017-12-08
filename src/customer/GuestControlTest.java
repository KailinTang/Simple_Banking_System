package customer;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

public class GuestControlTest {

	@Test
	public void testAddGuest() {
		ArrayList<Guest> guestList = new ArrayList<Guest>();	
		@SuppressWarnings("deprecation")
		Date asdf=new Date(2000-1900,12-1,12); 
		Guest guest=new Guest(101,"Kailin","China",asdf);
		guestList=new GuestControl().addGuest(guest, guestList);
		assertEquals("Error", guestList.get(0).getID(), 101);
	}

	@Test
	public void testDeleteGuest() {
		ArrayList<Guest> guestList = new ArrayList<Guest>();	
		@SuppressWarnings("deprecation")
		Date asdf=new Date(2000-1900,12-1,12); 
		Guest guest=new Guest(101,"Tim","China",asdf);
		guestList=new GuestControl().addGuest(guest, guestList);
		guestList=new GuestControl().deleteGuest(101, guestList);
		assertEquals("Error", guestList.size(), 0);
	}

}
