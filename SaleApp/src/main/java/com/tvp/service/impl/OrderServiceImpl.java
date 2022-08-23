/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.service.impl;

import com.tvp.pojo.Cart;
import com.tvp.pojo.SaleOrder;
import com.tvp.pojo.User;
import com.tvp.repository.OrderRepository;
import com.tvp.service.OrderService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tran van phuong
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;
    
    @Override
    public boolean addReceipt(Map<Integer, Cart> cart, User creator) {
        
        if(cart != null)
            
            return this.orderRepository.addReceipt(cart,creator);
        
        return false;
    }
    
}
