/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.service.impl;

import com.tvp.pojo.Food;
import com.tvp.repository.FoodRepository;
import com.tvp.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tran van phuong
 */
@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodRepository foodRepository;
    
    @Override
    public Food getFoodById(int foodId) {
        return this.foodRepository.getFoodById(foodId);
    }
    
    
}
