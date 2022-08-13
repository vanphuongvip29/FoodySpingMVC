/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.pojo;

import java.math.BigDecimal;

/**
 *
 * @author tran van phuong
 */
public class Cart {
    private int foodId;
    private String foodName;
    private Long price;
    private int quantity;

    /**
     * @return the FoodId
     */
    public int getfoodId() {
        return foodId;
    }

    /**
     * @param FoodId the FoodId to set
     */
    public void setfoodId(int FoodId) {
        this.foodId = FoodId;
    }

    /**
     * @return the foodName
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * @param foodName the foodName to set
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * @return the price
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
