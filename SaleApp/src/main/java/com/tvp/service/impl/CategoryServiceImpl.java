/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.service.impl;

import com.tvp.pojo.Category;
import org.springframework.stereotype.Service;
import com.tvp.repository.CategoryRepository;
import com.tvp.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author tran van phuong
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return this.categoryRepository.getCategories();
    }

    @Override
    public Category getCategoryById(int cateId) {
       return this.categoryRepository.getCategoryById(cateId);
    }

   

}   
