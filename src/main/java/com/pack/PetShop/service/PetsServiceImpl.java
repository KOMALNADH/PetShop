package com.pack.PetShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.PetShop.model.Pets;
import com.pack.PetShop.repository.PetsRepository;

@Service
@Transactional
public class PetsServiceImpl implements PetsService{
	
	@Autowired
	PetsRepository petsrepo;

	@Override
	public void savepet(Pets p) {
		petsrepo.save(p);
		
	}

	@Override
	public List<Pets> fetchAll() {
		
		return petsrepo.findAll();
	}

	@Override
	public List<Pets> fetchByOwnerId(Integer id) {
		List<Pets> list=petsrepo.findByOwnerId(id);
		return list;
	}

	@Override
	@Transactional
	public void UpdatePet(Integer user_id,Integer pet_id) {
		petsrepo.updateOwnerId(user_id,pet_id);
		
	}

}
