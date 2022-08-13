package com.tvp.pojo;

import com.tvp.pojo.Food;
import com.tvp.pojo.SaleOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-13T11:51:39")
@StaticMetamodel(OrderDetail.class)
public class OrderDetail_ { 

    public static volatile SingularAttribute<OrderDetail, Long> unitPrice;
    public static volatile SingularAttribute<OrderDetail, Integer> num;
    public static volatile SingularAttribute<OrderDetail, Food> foodId;
    public static volatile SingularAttribute<OrderDetail, SaleOrder> billId;
    public static volatile SingularAttribute<OrderDetail, Integer> id;

}