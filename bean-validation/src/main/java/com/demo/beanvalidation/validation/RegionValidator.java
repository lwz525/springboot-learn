package com.demo.beanvalidation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

public class RegionValidator implements ConstraintValidator<Region, String> {
   public void initialize(Region constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      HashSet<Object> regions = new HashSet<>();
      regions.add("China");
      regions.add("China-Taiwan");
      regions.add("China-HongKong");
      return regions.contains(obj);
   }
}
