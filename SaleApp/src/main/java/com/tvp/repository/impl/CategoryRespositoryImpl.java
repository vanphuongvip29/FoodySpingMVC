/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.repository.impl;

import com.tvp.pojo.Category;
import com.tvp.repository.CategoryRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
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
public class CategoryRespositoryImpl implements CategoryRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Category> getCategories() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("From Category");
        return q.getResultList();
    }

    @Override
    public Category getCategoryById(int cateId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Category.class, cateId);
    }

}
