package project.db.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AgeCheck implements
        ConstraintValidator<AgeValidator, Date> {

    @Override
    public void initialize(AgeValidator validator) {
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        Date current = new Date();
        long diff = ChronoUnit.YEARS.between(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),current.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        System.out.println(diff);
        return diff >= 18;
    }
}
