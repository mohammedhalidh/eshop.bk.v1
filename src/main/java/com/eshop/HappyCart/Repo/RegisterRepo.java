package com.eshop.HappyCart.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshop.HappyCart.Model.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Integer>{
	Register findByUsername(String username);

}
