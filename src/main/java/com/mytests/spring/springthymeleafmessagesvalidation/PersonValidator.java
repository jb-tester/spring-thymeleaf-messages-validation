package com.mytests.spring.springthymeleafmessagesvalidation;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

// support references in ValidationUtils methods
@Service
public class PersonValidator implements Validator {


    public boolean supports(Class clazz) {
        return Person.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "error.name.empty");
        Person p = (Person) obj;
        if (p.getAge() < 0) {
            e.rejectValue("age", "error.age.invalid");
        } else if (p.getAge() > 120) {
            e.rejectValue("age", "error.age.tooOld");
        }
      }
}