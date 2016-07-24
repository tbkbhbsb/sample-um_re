package um_tbkbhbsb.domain.validator;

import java.text.DateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<DateCheck, String>{

	@Override
	public void initialize(DateCheck consconstraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		return isDateFValid(value);
	}

	static boolean isDateFValid(String date){
		if (date.length() != 10) {
            return false;
        }
        DateFormat format = DateFormat.getDateInstance();
        format.setLenient(false);
        try {
            format.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
		
	}
	
}
