/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tvp.pojo.Food;
import com.tvp.repository.FoodRepository;
import com.tvp.service.FoodService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tran van phuong
 */
@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public Food getFoodById(int foodId) {
        return this.foodRepository.getFoodById(foodId);
    }

    @Override
    public boolean addOrUpdate(Food food) {
        try {

            Map r = this.cloudinary.uploader().upload(food.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));

            food.setImage((String) r.get("secure_url"));

            

            return this.foodRepository.addOrUpdate(food);

        } catch (IOException ex) {
            System.err.println("=== ADD STORE ==" + ex.getMessage());
        }

        return false;
    }

   
}
