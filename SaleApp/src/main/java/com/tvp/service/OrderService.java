/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tvp.service;

import com.tvp.pojo.Cart;
import java.util.Map;

/**
 *
 * @author tran van phuong
 */
public interface OrderService {
    boolean addReceipt(Map<Integer, Cart> cart);
}
