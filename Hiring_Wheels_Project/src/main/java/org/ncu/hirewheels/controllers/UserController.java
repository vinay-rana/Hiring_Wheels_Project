package org.ncu.hirewheels.controllers;

import java.util.HashMap;

import javax.validation.Valid;
import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.exceptions.UnAuthorizedUserException;
import org.ncu.hirewheels.exceptions.UserNotFoundException;
import org.ncu.hirewheels.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value="/hirewheels/v1/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
		if(userService.signUp(user)) {
			return ResponseEntity.ok("User successfully Added !");
		}
		else {
			return ResponseEntity.ok("User failded to Add");
		}
	}
	
	@PostMapping(value="/hirewheels/v1/signin")
	public ResponseEntity<Object> loginUser(@RequestBody HashMap<String,String> authDetails) throws UnAuthorizedUserException,UserNotFoundException{
		try {
			return new ResponseEntity<Object>(userService.signIn(authDetails.get("emailID"), authDetails.get("password")),HttpStatus.ACCEPTED);
		}catch(UnAuthorizedUserException ue) {
			return new ResponseEntity<Object>(new String("UnAuthorized User"),HttpStatus.UNAUTHORIZED);
		}catch(UserNotFoundException ufe) {
			return new ResponseEntity<Object>(new String("User Not Found"),HttpStatus.NOT_FOUND);
		}
	}
	
}