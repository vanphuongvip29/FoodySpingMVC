/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.repository.impl;

import com.tvp.pojo.Cart;
import com.tvp.pojo.OrderDetail;
import com.tvp.pojo.SaleOrder;
import com.tvp.repository.FoodRepository;
import com.tvp.repository.OrderRepository;
import com.tvp.repository.UserRepository;
import com.tvp.utils.Utils;
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tran van phuong
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED )
    public boolean addReceipt(Map<Integer, Cart> cart) {

        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            SaleOrder order = new SaleOrder();
            order.setUserId(this.userRepository.getUserById(6));
            order.setCreatedDate(new Date());

            Map<String, String> stats = Utils.cartStats(cart);
            Long.parseLong(stats.get("amount"));

            session.save(order);

            for (Cart c : cart.values()) {
                OrderDetail d = new OrderDetail();
                d.setBillId(order);
                d.setFoodId(this.foodRepository.getFoodById(c.getfoodId()));
                d.setUnitPrice(c.getPrice());
                d.setNum(c.getQuantity());

                session.save(d);
            }
            
            return true;

        } catch (HibernateException ex)
        {
            ex.printStackTrace();
        }
        return false;
        }

    }
