/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tvp.repository;

import com.tvp.pojo.Food;
import java.util.List;

/**
 *
 * @author tran van phuong
 */
public interface FoodRepository {
    Food getFoodById(int foodId);
    

    boolean addOrUpdate(Food food);
}
