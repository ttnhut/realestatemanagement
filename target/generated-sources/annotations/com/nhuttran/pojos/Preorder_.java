package com.nhuttran.pojos;

import com.nhuttran.pojos.Product;
import com.nhuttran.pojos.User;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2021-12-28T16:52:03")
@StaticMetamodel(Preorder.class)
public class Preorder_ { 

    public static volatile SingularAttribute<Preorder, Date> date;
    public static volatile SingularAttribute<Preorder, Product> productId;
    public static volatile SingularAttribute<Preorder, BigDecimal> price;
    public static volatile SingularAttribute<Preorder, Integer> id;
    public static volatile SingularAttribute<Preorder, User> userId;

}