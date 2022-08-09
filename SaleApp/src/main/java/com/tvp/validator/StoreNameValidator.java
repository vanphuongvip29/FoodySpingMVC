/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.validator;

import com.tvp.pojo.Store;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author tran van phuong
 */
@Component
public class StoreNameValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Store.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
//        Store s = (Store) o;
//        if(!s.getName().contains("Store"))
//            errors.rejectValue("name", "store.name.myErr");
    }
    
}
