package com.tvp.pojo;

import com.tvp.pojo.CommentRating;
import com.tvp.pojo.FollowRating;
import com.tvp.pojo.SaleOrder;
import com.tvp.pojo.Store;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-23T19:54:18")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> lastName;
    public static volatile CollectionAttribute<User, SaleOrder> saleOrderCollection;
    public static volatile CollectionAttribute<User, Store> storeCollection;
    public static volatile SingularAttribute<User, Integer> active;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile CollectionAttribute<User, CommentRating> commentRatingCollection;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;
    public static volatile CollectionAttribute<User, FollowRating> followRatingCollection;

}