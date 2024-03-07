package com.eshop.HappyCart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.HappyCart.Model.Register;
import com.eshop.HappyCart.Repo.RegisterRepo;

@Service
public class RegisterService {
	@Autowired
	private RegisterRepo registerrepo;
	
	 public Register registerUser(Register user) {
	        if (registerrepo.findByUsername(user.getUsername()) != null) {
	            throw new RuntimeException("Username already exists");
	            } 
	        return registerrepo.save(user);
	    }
	 
	 public Register getUserByUsername(String username) {
	        return registerrepo.findByUsername(username);
	    }

}
