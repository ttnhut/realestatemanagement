/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.repository.Impl;


import com.nhuttran.pojos.User;
import com.nhuttran.repository.UserRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Asus
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
   
    @Override
    public boolean addUser(User user) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try{
            session.save(user);
            return true;
        }
        
        catch(HibernateException ex){System.err.println(ex.getMessage());}
        return false;
    }

    @Override
    public List<User> getUsers(String username) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        try{
        if(!username.isEmpty()&&username!=null){
            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
            query.where(p);
        }
        }catch(NullPointerException ex){
            System.err.println("GET USERS" + ex.getMessage());
        }
        Query q = session.createQuery(query);
        return q.getResultList();
    }
    
}
