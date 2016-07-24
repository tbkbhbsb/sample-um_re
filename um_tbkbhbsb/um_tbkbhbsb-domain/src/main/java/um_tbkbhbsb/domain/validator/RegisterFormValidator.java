package um_tbkbhbsb.domain.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import um_tbkbhbsb.domain.Form.RegisterForm;

@Component
public class RegisterFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return RegisterForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasFieldErrors("password")) {
			return;
		}

		RegisterForm form = (RegisterForm) target;
		String password = form.getPassword();
		String passwordConfirm = form.getPasswordConfirm();

		if (!password.equals(passwordConfirm)) {
			errors.rejectValue("password", "PasswordEqualsValidator.passwordResetForm.password",
					"password and confirm password must be same.");
		}

	}

}
