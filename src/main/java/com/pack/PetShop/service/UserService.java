package com.pack.PetShop.service;

import java.util.List;

import com.pack.PetShop.model.User;

public interface UserService {
	public  void save(User u);
	public List<User> fetchAll();
	User findByUsername(String User);
	User findById(Integer id);
	public User findByPassword(String Password);
	User findByUserAndPassword(String user,String password);
}
