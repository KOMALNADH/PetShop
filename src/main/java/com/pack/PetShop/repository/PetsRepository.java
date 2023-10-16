package com.pack.PetShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.pack.PetShop.model.Pets;

public interface PetsRepository extends JpaRepository<Pets,Integer>{
	
	
	List<Pets> findByOwnerId(Integer id);
	
	@Modifying
	@Transactional
	@Query("update Pets p  set p.owner.id= :oid where p.Pet_id= :pid")
	void updateOwnerId(@Param("oid")Integer id,@Param("pid")Integer pet_id);
}
