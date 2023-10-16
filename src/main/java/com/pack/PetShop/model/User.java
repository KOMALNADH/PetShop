package com.pack.PetShop.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name= "user")
public class User {
	@Id
	private Integer id;
	private String user;
	private String password;
	@Transient
	private String confirmPassword;
	@OneToMany(mappedBy="owner")
	private List<Pets> pets=new ArrayList<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public List<Pets> getPets() {
		return pets;
	}
	public void setPets(List<Pets> pets) {
		this.pets = pets;
	}
	
	public User(Integer id, String user, String password, String confirmPassword, List<Pets> pets) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.pets = pets;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
