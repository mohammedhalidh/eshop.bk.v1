package com.eshop.HappyCart.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshop.HappyCart.Model.AdminAdd;

@Repository
public interface AdminAddRepo extends JpaRepository<AdminAdd, Integer> {
	

}
