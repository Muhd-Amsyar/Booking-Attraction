package com.sddevops.BookingAttraction;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;


public class UserCollectionTesting {
private UserCollection uc;

	private User u1;
	private User u2;
	private User u3;
	private User u4;
	private final int USER_COLLECTION_SIZE = 4;

  @BeforeTest
  public void beforeTest() {
		uc = new UserCollection();
		u1 = new User(1,"user1@mail.com","user1123","User1");
		u2 = new User(2,"user2@mail.com","user2123","User2");
		u3 = new User(3,"user3	@mail.com","user3123","User3");
		u4 = new User(4,"user4@mail.com","user4123","User4");
		uc.addUser(u1);
		uc.addUser(u2);
		uc.addUser(u3);
		uc.addUser(u4);
		uc.loginUser(u1);
		uc.loginUser(u2);
		uc.loginUser(u3);
		uc.loginUser(u4);
  }

  @Test
  public void f() {
		assertNotNull(uc);
  }
  
  @Test
  void testGetUsers() {
		assertEquals(4,uc.getUsers().size());
		
	}
  
  @Test
  void testAddUser() {
		//fail("Not yet implemented");
		List<User>testUc = uc.getUsers();
		//assertEquals(testUc.size(),USER_COLLECTION_SIZE);
		uc.addUser(u1);
		assertEquals(uc.getUsers().size(), USER_COLLECTION_SIZE +1);
		
	}
  @Test
  void testLoginUser() {
		List<User>testUc = uc.getUsers();
		//assertEquals(testUc.size(),USER_COLLECTION_SIZE);
		//assertEquals(uc.getUsers().get(0),u1);
		uc.loginUser(u1);
		assertEquals(uc.getUsers().size(), USER_COLLECTION_SIZE);
	}
  @Test
	void testUpdateUser() {
		List<User>testUc = uc.getUsers();
		//assertEquals(testUc.size(),USER_COLLECTION_SIZE);
		u2 = new User(2,"user2@mail.com","user21234","User2");
		uc.updateUser(u2);
		assertEquals(uc.getUsers().size(), USER_COLLECTION_SIZE);
	}
  @Test
	void testDeleteUser() {
		List<User>testUc = uc.getUsers();
		//assertEquals(testUc.size(),USER_COLLECTION_SIZE);
		uc.deleteUser(u1);
		assertEquals(USER_COLLECTION_SIZE -1,uc.getUsers().size(),USER_COLLECTION_SIZE);
	}
}
