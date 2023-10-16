package com.pack.PetShop.service;

import java.util.List;

import com.pack.PetShop.model.Pets;

public interface PetsService {
	public void savepet(Pets pet);
	public List<Pets> fetchAll();
	public List<Pets> fetchByOwnerId(Integer id);
	public void UpdatePet(Integer user_id,Integer pet_id);
}
