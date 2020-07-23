import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void addCamcorderTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void addChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
	}
	
	@Test
	public void retrieveAllCamcorderTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void retrieveAllChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
	}

	@Test
	public void doLoanCamcorderTest() {
		//fail("Not yet implemented");
		// write your code here
<<<<<<< HEAD
		//String cct = null;
		ResourceCentre.addCamcorder(camcorderList, cc2);
		cc2.setIsAvailable(false);
		boolean ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0012", "8-8-2020");
		assertFalse("Test that un-available item is NOT ok to loan?", ok);
		
		//error condition
		ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0013", "8-8-2020");
		assertFalse("Test that non-existing item is NOT ok to loan?", ok);
=======
>>>>>>> branch 'master' of https://github.com/19039761BenedictBryceLim/L10ResourceCentre.git
		
		//Error Condition - Unavailable/Already loaned item can't be loaned/borrowed again
		ResourceCentre.addCamcorder(camcorderList, cc1);
		cc1.setIsAvailable(false);
		boolean check1 = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "8-8-2020");
	
		assertFalse("Test that unavailable item is NOT okay to be loaned" , check1);
	
		//Normal Condition - Loaning an item
		ResourceCentre.addCamcorder(camcorderList, cc1);
		cc1.setIsAvailable(true);
		boolean check2 = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "9-10-2020");
		
		assertTrue("Test that available item is okay to returned", check2);
	
	}
	
	@Test
	public void doLoanChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		
		// error condition
		boolean ok = ResourceCentre.doLoanChromebook(chromebookList,"CB0013", "8-8-2020");
		assertFalse("Test that invalid item is NOT ok to loan?", ok); 
		
		// normal condition
		boolean okay = ResourceCentre.doLoanChromebook(chromebookList, cb1.getAssetTag(), "8-8-2020");
		assertTrue("Test that if chromebook is available for loan and is a valid item to loan", okay);
		
		
		
	}
	
	@Test
	public void doReturnCamcorderTest() {
		//fail("Not yet implemented");
		// write your code here
		
		//Error condition - Returning a non loaned item
		cc2.setIsAvailable(true);
		boolean check3	= ResourceCentre.doReturnCamcorder(camcorderList, "CC0012");
		assertFalse("Test non-loaned item is NOT okay to returned", check3 );
		
		
		//Normal Condition - Returning a loaned item
		cc1.setIsAvailable(false);
		boolean check4	= ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
		assertFalse("Test that loaned item is okay to be returned", check4 );
		
	}
	@Test
	public void doReturnChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		//Normal
		ResourceCentre.addChromebook(chromebookList, cb1);
		cb1.setIsAvailable(true);
		assertTrue("Test that return item will change to available to loan", cb1.getIsAvailable());
		//Error
		boolean check = ResourceCentre.doReturnChromebook(chromebookList, "CB0013");
		assertFalse("Test that only items in list can be returned", check);
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
