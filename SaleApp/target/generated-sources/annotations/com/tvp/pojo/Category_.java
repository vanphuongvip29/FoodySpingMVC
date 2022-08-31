package com.tvp.pojo;

import com.tvp.pojo.Store;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-30T22:19:32")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile CollectionAttribute<Category, Store> storeCollection;
    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, Integer> id;

}