package com.eshop.HappyCart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.HappyCart.Model.Register;
import com.eshop.HappyCart.Service.RegisterService;

@RestController
@RequestMapping("/user")
public class RegisterController {

	@Autowired
	private RegisterService registerservice;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody Register register) {
		if (registerservice.getUserByUsername(register.getUsername()) != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
		}
		Register userdata = registerservice.registerUser(register);
		return ResponseEntity.status(HttpStatus.OK).body(userdata);
	}

	@GetMapping("/check-username/{username}")
	public ResponseEntity<?> checkUsernameExists(@PathVariable String username) {
		Register existingUser = registerservice.getUserByUsername(username);
		if (existingUser != null) {
			return ResponseEntity.ok().body(true); // Username exists
		} else {
			return ResponseEntity.ok().body(false); // Username does not exist
		}
	}

}
