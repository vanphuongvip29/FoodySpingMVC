/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.repository.impl;

import com.tvp.pojo.Food;
import com.tvp.pojo.Store;
import com.tvp.repository.FoodRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tran van phuong
 */
@Repository
@Transactional
public class FoodRepositoryImpl implements FoodRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public Food getFoodById(int foodId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Food.class, foodId);
    }

    @Override
    public boolean addOrUpdate(Food food) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(food);
            
            return true;
        } catch (Exception ex) {
            System.err.println("===ADD STORE ERR ==" + ex.getMessage());
            ex.printStackTrace();
        }
        
        return false;
    }


    
}
