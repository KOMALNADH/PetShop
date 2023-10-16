package com.pack.PetShop.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pack.PetShop.model.Pets;

@Component
public class PetValidator implements Validator{

	@Override
	public boolean supports(Class<?> aClass) {
		return Pets.class.equals(aClass);
	}

	@Override
	public void validate(Object p, Errors errors) {
		Pets pet = (Pets) p;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pet_name", "NotEmpty");
        if (pet.getPet_name().length() < 4 || pet.getPet_name().length() > 32) {
           // errors.rejectValue("pet_name", "Size.addpet.pet_name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pet_age", "NotEmpty");
        if (pet.getPet_age() !=null) {
            //errors.rejectValue("password", "age.addpet.password");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pet_place", "NotEmpty");
        if (pet.getPet_place() != null) {
            //errors.rejectValue("pet_place", "place.addpet.pet_place");
        }

		
	}

}
