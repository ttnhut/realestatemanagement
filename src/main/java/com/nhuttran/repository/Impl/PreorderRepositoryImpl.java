/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.repository.Impl;

import com.nhuttran.pojos.Preorder;
import com.nhuttran.repository.PreorderRepository;
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
import com.nhuttran.pojos.User;
/**
 *
 * @author Asus
 */
@Repository
@Transactional
public class PreorderRepositoryImpl implements PreorderRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public boolean addPreOrder(Preorder prev) {
        try {
            Session session = sessionFactory.getObject().getCurrentSession();
            session.save(prev);
            return true;
        }
        catch(HibernateException ex){
            System.err.println("----ADD PREORDER" + ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Preorder> getPreorders(String kw) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Preorder> query = builder.createQuery(Preorder.class);
        Root root = query.from(Preorder.class);
        if(!kw.isEmpty() && kw !=null){
            User user = session.get(User.class, kw);
            Predicate p = builder.equal(root.get("userId").as(User.class), user);
            query = query.where(p);
        }
        
        query = query.select(root);
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }
    
}
