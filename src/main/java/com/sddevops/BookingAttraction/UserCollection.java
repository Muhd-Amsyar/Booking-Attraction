package com.sddevops.BookingAttraction;
import java.util.*;

public class UserCollection {
	 private ArrayList<User> users = new ArrayList<>();
	 private String login;
	public UserCollection() {
		/*users.add(new User(1,"user1@mail.com","user1123","User1"));
   	users.add(new User(2,"user2@mail.com","user2123","User2"));
   	users.add(new User(3,"user3	@mail.com","user3123","User3"));
   	users.add(new User(4,"user4@mail.com","user4123","User4"));*/
	}
	public List<User> getUsers() {
		return users;
		
	}
   public void addUser(User user) {
   		users.add(user);
   }
   
   public void loginUser(User user) {
   users.get(0);
  }
   
   public void deleteUser(User user) {
		   users.remove(user);
  		
  }
   
   public void updateUser(User user) {
	   users.set(2,user);
 		
   }
   
}