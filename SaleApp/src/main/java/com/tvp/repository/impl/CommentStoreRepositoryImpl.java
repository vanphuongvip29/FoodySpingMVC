/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.repository.impl;

import com.tvp.pojo.FollowRating;
import com.tvp.repository.CommentStoreRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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
public class CommentStoreRepositoryImpl implements CommentStoreRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<FollowRating> getCommentsByStoreId(int storeId, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<FollowRating> query = builder.createQuery(FollowRating.class);
        Root root = query.from(FollowRating.class);

        query = query.where(builder.equal(root.get("storeId"), storeId));
        query = query.orderBy(builder.desc(root.get("id")));

        Query q = session.createQuery(query);

        int max = 2;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);

        return q.getResultList();
    }

    @Override
    public long CountComment(int storeId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Query q = session.createQuery("Select Count(*) From FollowRating Where storeId.id=:id");
        q.setParameter("id", storeId);

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public FollowRating addComment(FollowRating c) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(c);
            return c;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return null;
        
        
    }

}
