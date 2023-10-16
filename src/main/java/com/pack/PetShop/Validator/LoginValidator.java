package com.pack.PetShop.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import java.util.*;

import com.pack.PetShop.model.Pets;
import com.pack.PetShop.model.User;
import com.pack.PetShop.service.UserService;
@Component
public class LoginValidator implements Validator{

	@Autowired
	UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }


	@Override
	public void validate(Object o, Errors errors) {
		User user=(User) o;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user", "NotEmpty");
        if (userService.findByUsername(user.getUser()) == null) {
//            errors.rejectValue("user", "username.loginform.user");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (userService.findByPassword(user.getPassword()) == null) {
//            errors.rejectValue("user", "password.loginform.user");
        }

//      List<User> list=userService.fetchAll();
//      boolean b=false;
//      for(User u:list) {
//    	  if(user.getUser().equals(u.getUser())&&user.getPassword().equals(u.getPassword())){
//    		  b=true;
//    		  break;
//    	  }
//      }
//     
//      if(b==false) {
//    	 errors.reject("match.user.password");
//    	 errors.reject("not found", "didn't match");
//    	 
//      }
	}

	}
