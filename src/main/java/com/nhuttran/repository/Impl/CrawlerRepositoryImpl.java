/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.repository.Impl;

import com.nhuttran.pojos.Category;
import com.nhuttran.pojos.Product;
import com.nhuttran.repository.CrawlerRepository;
import com.nhuttran.service.Impl.CrawlerServiceImpl;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
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
public class CrawlerRepositoryImpl implements CrawlerRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public List<Product> crawData(String keyword) {
        List<Product> realsetateList = new ArrayList<>();
        String link = null;
        Category c = null;
        
        if(keyword.equals("chung cu")){
                link = "http://i-batdongsan.com/can-ban-can-ho-chung-cu.htm";
                Session session = sessionFactory.getObject().getCurrentSession();
                c = session.get(Category.class,3 );
           
        }
        else if(keyword.equals("nha o")){
                link = "http://i-batdongsan.com/can-ban-nha-mat-tien.htm";
                Session session = sessionFactory.getObject().getCurrentSession();
                c = session.get(Category.class,1 );
           
        }
        else if(keyword.equals("nha pho")){
                link = "http://i-batdongsan.com/can-ban-nha-ngo-hem.htm";
                Session session = sessionFactory.getObject().getCurrentSession();
                c = session.get(Category.class,2 );
           
        }
        try {
            Document doc = Jsoup.connect(link).timeout(5000).get();
            Elements titleList = doc.select("div[class=ct_title] a");
            for(int i=0;i<titleList.size();i++){
                Product p = new Product();
                p.setName(titleList.get(i).ownText());
                p.setCategoryId(c);
                
               
                realsetateList.add(p);
            }
            Elements priceList = doc.select("div[class=ct_price]");
            for(int i=0;i<realsetateList.size();i++){
                Product p = realsetateList.get(i);
                String price = priceList.get(i).ownText().replaceAll(" ", "").replaceAll(",", "").replaceAll("/m", "");
                if(price.contains(",") && price.contains("tỷ")){
                   price = price.replace("tỷ", "00000000");
                }
                else if (price.contains(",") && price.contains("triệu")){
                   price = price.replace("triệu", "00000");
                }
                else if(!price.contains(",") && price.contains("tỷ")){
                   price = price.replace("tỷ", "000000000");
                }
                else if(!price.contains(",") && price.contains("triệu")){
                   price =  price.replace("triệu", "000000");
                }
                else if(!price.contains(",") && price.contains("ngàn")){
                   price =  price.replace("ngàn", "000");
                }
                System.err.println(price);
                p.setPrice(new BigDecimal(Double.parseDouble(price)));
            }
            Elements contentList = doc.select("div[class=ct_brief]");
            for(int i=0;i<realsetateList.size();i++){
                Product p = realsetateList.get(i);
                p.setDescription(contentList.get(i).ownText());
            }
            Elements images = doc.select("div[class=thumbnail] img");
            for(int i=0;i<realsetateList.size();i++){
                Product p = realsetateList.get(i);
                p.setImage("http://i-batdongsan.com" + images.get(i).attr("src"));
            }
        } catch (IOException ex) {
            Logger.getLogger(CrawlerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return realsetateList;
    }

    @Override
    public boolean addDataByCrawing(List<Product> productList) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try{
        for(int i=0;i<productList.size();i++){
            session.save(productList.get(i));
            
        }
        return true;
        }catch(HibernateException ex){
            System.err.println("Craw DATA -----" + ex.getMessage());
        }
        return false;
    }
    
}
