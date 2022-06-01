package com.nhuttran.pojos;

import com.nhuttran.pojos.Preorder;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2021-12-28T16:52:03")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SetAttribute<User, Preorder> preorderSet;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SingularAttribute<User, String> username;

}