package org.ncu.hirewheels.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.ncu.hirewheels.DAO.RoleDAO;
import org.ncu.hirewheels.DAO.UserDAO;
import org.ncu.hirewheels.entities.Role;
import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.exceptions.UnAuthorizedUserException;
import org.ncu.hirewheels.exceptions.UserNotFoundException;
import org.ncu.hirewheels.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userRepository;
	
	@Autowired
	private RoleDAO roleRepository;

	@Override
	public boolean signUp(User user) {
		Role role = roleRepository.getRoleByName(user.getRole().getName());
		if(role != null) {
			role.getUsers().add(user);
			roleRepository.flush();
		}
		else {
			Role newRole = new Role(user.getRole().getName().toUpperCase());
			Set<User> users = new HashSet<>();
			users.add(user);
			newRole.setUsers(users);
			if(roleRepository.save(newRole)==null) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public User signIn(String emailID,String password) {
		User user = userRepository.findByEmailID(emailID);
		if(user != null){
			if(user.getPassword().equals(password)) {
				return user;
			}
			else {
				throw new UnAuthorizedUserException("Unauthorized User : "+emailID);
			}
		}
		else {
			throw new UserNotFoundException("User not found with "+emailID);
		}
	}
	
}
