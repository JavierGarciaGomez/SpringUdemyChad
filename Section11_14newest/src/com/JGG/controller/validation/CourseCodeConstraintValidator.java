package com.JGG.controller.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//166
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCodeValidator, String> {
   private String coursePrefix;

   @Override
   public void initialize(CourseCodeValidator constraint) {
      coursePrefix = constraint.prefixValue();
   }

   @Override
   public boolean isValid(String code, ConstraintValidatorContext context) {
      boolean result=false;
      if(code!=null){
         result=code.startsWith(coursePrefix);
      }
      return result;
   }
}
