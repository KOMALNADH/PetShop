package com.pack.PetShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.PetShop.model.User;
@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

	User findByUser(String user);
	User findByPassword(String Password);
	User findByUserAndPassword(String user,String password);

}
