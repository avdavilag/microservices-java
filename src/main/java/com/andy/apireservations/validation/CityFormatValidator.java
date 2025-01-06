package com.andy.apireservations.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CityFormatValidator implements ConstraintValidator<CityFormatConstraint, String> {

    @Override
    public void initialize(CityFormatConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
        return arg0 !=null &&  arg0.length() == 3 && arg0.matches("[A-Z]+");
    } 

}
