package com.sddevops.BookingAttraction;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;


public class AttractionTest {

	private AttractionCollection ac;
	private Attraction a1;
	private Attraction a2;
	private final int ATTRACTION_COLLECTION_SIZE = 2;
	
  @BeforeTest
  public void beforeTest() {
	  
		//Arrange
		ac = new AttractionCollection();
		a1 = new Attraction("0001","Universal Studios Singapore","This is a theme park","asdasdasda.png","55","11:00-19:00 open daily","sentosa 123456");
		a2 = new Attraction("0002","Singapore Zoo","This is a zoo","asdasdqweqwe.png","55","11:00-21:00 open daily","mandai 123456");
		ac.addAttraction(a1);
		ac.addAttraction(a2);
  }
  
	@Test
	void testAttractionCollection() {
		//test if attraction collection is null, test should be success if ac exist
		assertNotNull(ac);
	}

	/**
	 * Test method for {@link com.sddevops.BookingAttraction.AttractionCollection#getAttractions()}.
	 */
	@Test
	void testGetAttractions() {
		
	assertEquals(2,ac.getAttractions().size());
	
	}
	
	@Test
	void testGetOneAttraction() {
		
		//since index 0 is a1, if test is successful means it is able to get one attraction
	assertEquals(ac.getAttractions().get(0), a1);
	
	}
	

	/**
	 * Test method for {@link com.sddevops.BookingAttraction.AttractionCollection#addAttraction(com.sddevops.BookingAttraction.Attraction)}.
	 */
	@Test
	void testAddAttraction() {
	
		List<Attraction> testAc = ac.getAttractions();
		
		assertEquals(testAc.size(), ATTRACTION_COLLECTION_SIZE);
	
		ac.addAttraction(a1);
		
		assertEquals(ac.getAttractions().size(), ATTRACTION_COLLECTION_SIZE+1);
		
	}
	
	@Test
	void testDeleteAttraction() {
	
		List<Attraction> testAc = ac.getAttractions();
		
		assertEquals(testAc.size(), ATTRACTION_COLLECTION_SIZE);
		
		ac.deleteAttraction(a1);
		
		assertEquals(ac.getAttractions().size(), ATTRACTION_COLLECTION_SIZE-1);
			
	}
	
	@Test 
	void testUpdateAttraction() {
	}

}
