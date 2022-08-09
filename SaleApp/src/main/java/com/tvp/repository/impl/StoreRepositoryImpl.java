/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.repository.impl;


import com.tvp.pojo.Store;
import com.tvp.repository.StoreRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
public class StoreRepositoryImpl implements StoreRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Store> getStore(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Store> query = builder.createQuery(Store.class);
        Root root = query.from(Store.class);
        
        query = query.select(root);
        
        if(kw != null)
        {
            Predicate p = builder.like(root.get("name").as(String.class),
                    String.format("%%%s%%",kw));
            query = query.where(p);
            
           
        }
        
        query = query.orderBy(builder.desc(root.get("id")));
        Query q = session.createQuery(query);
        
        int max = 9;
        q.setMaxResults(max);
        q.setFirstResult((page-1)* max);
        return q.getResultList();
    }

    @Override
    public long countStore() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Store");
        
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public Store getStoreById(int storeId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Store.class, storeId);
    }

    @Override
    public boolean addOrUpdate(Store store) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(store);
            
            return true;
        } catch (Exception ex) {
            System.err.println("===ADD STORE ERR ==" + ex.getMessage());
            ex.printStackTrace();
        }
        
        return false;
    }

}
