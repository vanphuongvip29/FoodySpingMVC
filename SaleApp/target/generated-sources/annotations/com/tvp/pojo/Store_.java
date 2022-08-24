package com.tvp.pojo;

import com.tvp.pojo.Category;
import com.tvp.pojo.FollowRating;
import com.tvp.pojo.Food;
import com.tvp.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-24T09:10:39")
@StaticMetamodel(Store.class)
public class Store_ { 

    public static volatile SingularAttribute<Store, String> image;
    public static volatile SingularAttribute<Store, String> address;
    public static volatile SingularAttribute<Store, String> name;
    public static volatile SingularAttribute<Store, Integer> id;
    public static volatile SingularAttribute<Store, User> userId;
    public static volatile CollectionAttribute<Store, Food> foodCollection;
    public static volatile SingularAttribute<Store, Category> categoryId;
    public static volatile CollectionAttribute<Store, FollowRating> followRatingCollection;

}