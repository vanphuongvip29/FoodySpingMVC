/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.repository.impl;

import com.tvp.pojo.Category;
import com.tvp.pojo.Food;
import com.tvp.pojo.OrderDetail;
import com.tvp.pojo.SaleOrder;
import com.tvp.pojo.Store;
import com.tvp.pojo.StoreFood;
import com.tvp.repository.StatsRepository;
import java.util.ArrayList;
import java.util.Date;
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
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object> cateStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootS = q.from(Store.class);
        Root rootC = q.from(Category.class);

        q.where(b.equal(rootS.get("categoryId"), rootC.get("id")));

        q.multiselect(rootC.get("id"), rootC.get("name"),
                b.count(rootS.get("id")));

        q.groupBy(rootC.get("id"));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object> storeStats(Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rS = q.from(Store.class);
        Root rSF = q.from(StoreFood.class);
        Root rF = q.from(Food.class);
        Root rO = q.from(SaleOrder.class);
        Root rD = q.from(OrderDetail.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rSF.get("storeId"), rS.get("id")));
        predicates.add(b.equal(rSF.get("foodId"), rF.get("id")));
        predicates.add(b.equal(rD.get("foodId"), rF.get("id")));
        predicates.add(b.equal(rD.get("billId"), rO.get("id")));

        q.multiselect(rS.get("id"), rS.get("name"), b.sum(b.prod(rD.get("num"), rD.get("unitPrice"))));

        

        if (fromDate != null) {
            predicates.add(b.greaterThanOrEqualTo(rO.get("createdDate"), fromDate));
        }

        if (toDate != null) {
            predicates.add(b.lessThanOrEqualTo(rO.get("createdDate"), toDate));
        }

        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(rS.get("id"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object> storeMonthStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rS = q.from(Store.class);
        Root rSF = q.from(StoreFood.class);
        Root rF = q.from(Food.class);
        Root rO = q.from(SaleOrder.class);
        Root rD = q.from(OrderDetail.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rSF.get("storeId"), rS.get("id")));
        predicates.add(b.equal(rSF.get("foodId"), rF.get("id")));
        predicates.add(b.equal(rD.get("foodId"), rF.get("id")));
        predicates.add(b.equal(rD.get("billId"), rO.get("id")));

        q.multiselect(b.function("MONTH", Integer.class, rO.get("createdDate")),
                b.function("YEAR", Integer.class, rO.get("createdDate")),
                b.sum(b.prod(rD.get("num"), rD.get("unitPrice"))));

        

        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(b.function("MONTH", Integer.class, rO.get("createdDate")),
                b.function("YEAR", Integer.class, rO.get("createdDate")));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

}
