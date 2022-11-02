package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.User;

public interface UserService {

	public boolean signUp(User user);
	
	public User signIn(String emailID,String password);
}
