package com.tvp.pojo;

import com.tvp.pojo.CommentRating;
import com.tvp.pojo.Store;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-09T10:07:25")
@StaticMetamodel(Food.class)
public class Food_ { 

    public static volatile SingularAttribute<Food, String> image;
    public static volatile CollectionAttribute<Food, Store> storeCollection;
    public static volatile SingularAttribute<Food, BigInteger> price;
    public static volatile CollectionAttribute<Food, CommentRating> commentRatingCollection;
    public static volatile SingularAttribute<Food, String> name;
    public static volatile SingularAttribute<Food, Boolean> active;
    public static volatile SingularAttribute<Food, Integer> id;

}