package com.pack.PetShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.PetShop.model.User;
import com.pack.PetShop.repository.UserRepo;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepo userrepo;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	public void save(User u) {
		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		userrepo.save(u);
		
	}

	@Override
	public List<User> fetchAll() {
		return userrepo.findAll();
	}

	@Override
	public User findByUsername(String User) {
		User user=userrepo.findByUser(User);
		return user;
	}

	@Override
	public User findById(Integer id) {
		Optional<User> user=userrepo.findById(id);
		return user.get();
	}

	@Override
	public User findByPassword(String Password) {
		User user=userrepo.findByPassword(Password);
		return user;
	}

	@Override
	public User findByUserAndPassword(String user, String password) {
		User u=userrepo.findByUser(user);
		
		if(u !=null) {
		String encoded=u.getPassword();
		boolean matches=bCryptPasswordEncoder.matches(password, u.getPassword());		
			if(matches) {
			User user1=userrepo.findByUserAndPassword(u.getUser(), encoded);
			return user1;
			}
		
		}
		
			return null;
	}

}

	


