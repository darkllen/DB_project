package project.db.security;

import project.db.security.AgeCheck;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeCheck.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeValidator {
    String message() default "Age should be > 18 year";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}