package com.pack.PetShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pets")
public class Pets {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Pet_id;
	private String pet_name;
	private Integer Pet_age;
	private String Pet_place;
	@ManyToOne
	@JoinColumn(name="owner_id")
	private User owner;
	public Integer getPet_id() {
		return Pet_id;
	}
	public void setPet_id(Integer pet_id) {
		Pet_id = pet_id;
	}
	public String getPet_name() {
		return pet_name;
	}
	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}
	public Integer getPet_age() {
		return Pet_age;
	}
	public void setPet_age(Integer pet_age) {
		Pet_age = pet_age;
	}
	public String getPet_place() {
		return Pet_place;
	}
	public void setPet_place(String pet_place) {
		Pet_place = pet_place;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public Pets(Integer pet_id, String pet_name, Integer pet_age, String pet_place, User owner) {
		super();
		Pet_id = pet_id;
		this.pet_name = pet_name;
		Pet_age = pet_age;
		Pet_place = pet_place;
		this.owner = owner;
	}
	public Pets() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
