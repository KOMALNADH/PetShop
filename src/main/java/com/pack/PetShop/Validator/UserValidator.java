package com.pack.PetShop.Validator;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pack.PetShop.model.User;
import com.pack.PetShop.service.UserService;

@Component
public class UserValidator implements Validator{
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
        if (user.getUser().length() < 4 || user.getUser().length() > 32) {
            errors.rejectValue("user", "Size.userform.user");
        }
        if (userService.findByUsername(user.getUser()) != null) {
            errors.rejectValue("user", "Duplicate.userform.user");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 4 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userform.password");
        }
//        if (userService.findByPassword(user.getPassword()) != null) {
//            errors.rejectValue("password", "Duplicate.userform.password");
//        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
        }
		
	}

	

}
