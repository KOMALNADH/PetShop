package com.pack.PetShop.controller;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import com.pack.PetShop.Validator.LoginValidator;
import com.pack.PetShop.Validator.PetValidator;
import com.pack.PetShop.Validator.UserValidator;
import com.pack.PetShop.model.Pets;
import com.pack.PetShop.model.User;
import com.pack.PetShop.repository.PetsRepository;
import com.pack.PetShop.service.PetsService;
import com.pack.PetShop.service.UserService;

@Controller
public class PetController {
	@Autowired
	UserService userservice;
	@Autowired
	PetsService petservice;
	@Autowired
	PetsRepository petrepo;
	@Autowired
	UserValidator uservalidator;
	@Autowired
	LoginValidator loginValid;
	@Autowired
	PetValidator petValidator;
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/registration")
	public String Userlogin(Model model) {
		model.addAttribute("userform", new User());
		return "registration";
	}
	@PostMapping("/registration")
	public String saveUser(@Valid @ModelAttribute("userform") User userform,Model model,BindingResult result,RedirectAttributes red) {
		uservalidator.validate(userform, result);
		String resultpage="";
		if(result.hasErrors()) {
			resultpage="registration";
		}
		else {
		Random r =new Random();
		int userid=r.nextInt(100);
		userform.setId(userid);
		userservice.save(userform);
		red.addFlashAttribute("registered", "Successfully registered");
		resultpage= "redirect:/login";
		}
		return resultpage;
	}
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginform", new User());
		return "login";
	}

	
	@PostMapping("/login1")
	public String home(@Valid @ModelAttribute("loginform") User loginform,Model model,BindingResult result,RedirectAttributes red) {
		String resultPage="";
		loginValid.validate(loginform, result);
		if(result.hasErrors()) {
			return "login";
		}
		else {
			if(userservice.findByUserAndPassword(loginform.getUser(), loginform.getPassword()) != null) {
				String user=loginform.getUser();
				User u1=userservice.findByUsername(user);
				model.addAttribute("userdetails", u1);
				List<Pets> list=petservice.fetchAll();
				model.addAttribute("petsList",list);
				model.addAttribute("login", "successfully logged in");
				red.addFlashAttribute("user",user);
				resultPage="home";
			}
			else {
				model.addAttribute("login","invalid username or password");
				return "login";
			}
//			String user=loginform.getUser();
//			User u1=userservice.findByUsername(user);
//			model.addAttribute("userdetails", u1);
//			List<Pets> list=petservice.fetchAll();
//			model.addAttribute("petsList",list);
//			red.addFlashAttribute("user",user );
//			resultPage="home";
			}
		return resultPage;
//		model.addAttribute("userdetails", user);
//		String str=null;
//		List<User> list=userservice.fetchAll();
//		for(User u:list) {
//			if((user.getUser().equals(u.getUser())) && (user.getPassword().equals(u.getPassword()))) {
//				List<Pets> list1=petservice.fetchAll();
//				model.addAttribute("petsList",list1);
//				model.addAttribute("Available","Buy");
//				str= "home";
//				break;
//			}
//			else {
//				str= "redirect:/login";
//			}
//		}
//		return str;
		
		
	}

	
	
	
	@GetMapping("/add")
	public String addpet(Model model,@RequestParam("user") String user) {
		User u=userservice.findByUsername(user);
		System.out.println(u);
		model.addAttribute("userdetails", u.getUser());
		model.addAttribute("addpet", new Pets());

		return "addPet";
	}
	@PostMapping("/savepet")
	public String PetsAdded(@RequestParam("user") String user,@ModelAttribute("addpet") Pets pet,Model model,BindingResult result,RedirectAttributes red) {
		User u1=userservice.findByUsername(user);
		
		red.addFlashAttribute("userdetails", u1.getUser());
		petValidator.validate(pet, result);
		String resultpage="";
		if(result.hasErrors()) {
			model.addAttribute("userdetails", user);
			resultpage="addPet";
		}
		else {
			User u=userservice.findByUsername(user);
//			pet.setOwner(u);
			petservice.savepet(pet);
			
			resultpage="redirect:/getpets";
		}
		return resultpage;
	}
	@GetMapping("/getpets")
	public String getPets(@ModelAttribute("userdetails") String user,Model model) {
		User u=userservice.findByUsername(user);
		model.addAttribute("userdetails", u);
		List<Pets> list=petservice.fetchAll();
		model.addAttribute("petsList",list);
		
		return "home";
	}
	@GetMapping("/mypets")
	public String MyPets(Model model,@RequestParam("user") String user) {
		User u=userservice.findByUsername(user);
		Integer user_id=u.getId();
		model.addAttribute("userdetails", user);
		
		List<Pets> list2=petservice.fetchByOwnerId(user_id);
		model.addAttribute("mypets", list2);
		return "MyPets";
	}
	@GetMapping("/buy")
	public String BuyPets(Model model,@RequestParam("user") String user,@RequestParam("pets_id") Integer Pet_id,RedirectAttributes red) {
		red.addFlashAttribute("userdetails", user);
		User u=userservice.findByUsername(user);
		Integer user_id=u.getId();
		petrepo.updateOwnerId(user_id, Pet_id);
		
		return "redirect:/getpets";
		
	}
	@GetMapping("/home")
	public String home(@RequestParam("user") String user,Model model,RedirectAttributes red) {
		red.addFlashAttribute("userdetails", user);
		User u=userservice.findByUsername(user);
		model.addAttribute("userdetails", u);
		List<Pets> list=petservice.fetchAll();
		model.addAttribute("petsList",list);
		
		return "home";
	}
	@GetMapping("/error")
	public String accessDenied() {
		return "403";
	}
}
