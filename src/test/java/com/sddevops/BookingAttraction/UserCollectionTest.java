/**
 * 
 */
package com.sddevops.BookingAttraction;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author amsya
 *
 */
class UserCollectionTest {
	private UserCollection uc;
	
	private User u1;
	private User u2;
	private User u3;
	private User u4;
	private final int USER_COLLECTION_SIZE = 4;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
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

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.sddevops.BookingAttraction.UserCollection#getUsers()}.
	 */
	@Test
	void testGetUsers() {
		assertEquals(4,uc.getUsers().size());
		
	}

	/**
	 * Test method for {@link com.sddevops.BookingAttraction.UserCollection#addUser(com.sddevops.BookingAttraction.User)}.
	 */
	@Test
	void testAddUser() {
		//fail("Not yet implemented");
		List<User>testUc = uc.getUsers();
		assertEquals(testUc.size(),USER_COLLECTION_SIZE);
		uc.addUser(u1);
		assertEquals(uc.getUsers().size(), USER_COLLECTION_SIZE +1);
		
	}
	@Test
	void testLoginUser() {
		List<User>testUc = uc.getUsers();
		assertEquals(uc.getUsers().get(0),u1);
		uc.loginUser(u1);
		assertEquals(uc.getUsers().size(), USER_COLLECTION_SIZE);
	}
	@Test
	void testUpdateUser() {
		List<User>testUc = uc.getUsers();
		assertEquals(testUc.size(),USER_COLLECTION_SIZE);
		u2 = new User(2,"user2@mail.com","user21234","User2");
		uc.updateUser(u2);
		assertEquals(uc.getUsers().size(), USER_COLLECTION_SIZE);
	}
	@Test
	void testDeleteUser() {
		List<User>testUc = uc.getUsers();
		assertEquals(testUc.size(),USER_COLLECTION_SIZE);
		uc.deleteUser(u1);
		assertEquals(uc.getUsers().size(), USER_COLLECTION_SIZE -1);
	}
	
}
