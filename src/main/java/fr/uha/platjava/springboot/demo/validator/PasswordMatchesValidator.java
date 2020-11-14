package fr.uha.platjava.springboot.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.uha.platjava.springboot.demo.data.AppUserDTO;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		AppUserDTO dto = (AppUserDTO)value;
		return dto.getPassword().equals(dto.getPasswordMatch());
	}

}
