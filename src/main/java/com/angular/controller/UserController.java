package com.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import com.angular.entity.User;
import com.angular.repo.UserRepo;

@RestController
public class UserController {
	
	public final static String SUCCESS_MESSAGE = "logged in successfully";
	public static final String INVALID_PASSWORD = "invalid password";
	public static final String INVALID_USER = "invalid userName";
 
	@Autowired
	private UserRepo repository;
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping(path = { "/login" })
	public ResponseEntity<String> login(@RequestBody Map<String, String> userDetails) {
 
		User user = repository.findByUserName(userDetails.get("userName"));
		if (user != null) {
			if (user.getPassword().equals(userDetails.get("password"))) {
				return new ResponseEntity("{\"message\":\"" + SUCCESS_MESSAGE + "\"}", HttpStatus.OK);
			} else {
				return new ResponseEntity("{\"message\":\"" + INVALID_PASSWORD + "\"}", HttpStatus.OK);
			}
		} else {
			return new ResponseEntity("{\"message\":\"" + INVALID_USER + "\"}", HttpStatus.OK);
		}
	}
}


