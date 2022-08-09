/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.formatter;

import com.tvp.pojo.Category;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author tran van phuong
 */
public class CategoryFormatter implements Formatter<Category>{

    @Override
    public String print(Category t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Category parse(String cateId, Locale locale) throws ParseException {
        Category c = new Category();
        c.setId(Integer.parseInt(cateId));
        
        return c;
    }
    
}
