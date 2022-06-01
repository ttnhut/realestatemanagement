/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.repository.Impl;

import com.nhuttran.pojos.Category;
import com.nhuttran.pojos.Product;
import com.nhuttran.repository.ProductRepository;

import java.math.BigDecimal;

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
 * @author Asus
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public List<Product> getProducts(String kw) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root root = query.from(Product.class);
        query = query.select(root);
        try{
        if(!kw.isEmpty()&&kw!=null){
            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            
            query = query.where(builder.or(p));
            try{
            Category c = session.get(Category.class, Integer.parseInt(kw));
            Predicate p1 = builder.equal(root.get("categoryId").as(Category.class),c);
            Predicate p2 = builder.equal(root.get("id").as(Long.class), Long.parseLong(kw));
            Predicate p3 = builder.equal(root.get("price").as(BigDecimal.class), new BigDecimal(Double.parseDouble(kw)));
            query = query.where(builder.or(p,p1,p2,p3));
            }catch(Exception ex){
                System.err.println(ex.getMessage());
            }
            
            
        }
        }catch(NullPointerException ex){
            System.err.println(ex.getMessage());
        }
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdate(Product product) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try{
            session.save(product);
            
            return true;
        }catch(Exception ex){
            System.err.println("----ADD PRODUCT-----" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

   

  
    
}
