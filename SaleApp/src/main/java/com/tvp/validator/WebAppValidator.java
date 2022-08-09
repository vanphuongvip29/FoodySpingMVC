/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.validator;

import com.tvp.pojo.Store;
import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author tran van phuong
 */
@Component
public class WebAppValidator implements Validator {

    @Autowired
    private javax.validation.Validator beanValidator;

    private Set<Validator> springValidators;

    @Override
    public boolean supports(Class<?> type) {
        return Store.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Set<ConstraintViolation<Object>> beans
                = this.beanValidator.validate(o);

        for (ConstraintViolation<Object> obj : beans) {
            errors.rejectValue(obj.getPropertyPath().toString(),
                    obj.getMessageTemplate(), obj.getMessage());
        }
        for (Validator v : this.springValidators) {
            v.validate(o, errors);
        }

    }

    /**
     * @param springValidators the springValidators to set
     */
    public void setSpringValidators(Set<Validator> springValidators) {
        this.springValidators = springValidators;
    }

}
