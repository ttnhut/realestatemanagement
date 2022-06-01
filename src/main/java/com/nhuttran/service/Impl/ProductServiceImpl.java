/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nhuttran.controllers.ProductController;
import com.nhuttran.pojos.Product;
import com.nhuttran.repository.ProductRepository;
import com.nhuttran.service.ProductService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Cloudinary cloudinary;
    @Override
    public List<Product> getProducts(String kw) {
        return productRepository.getProducts(kw);
    }

    @Override
    public boolean addOrUpdate(Product product) {
              try {
                Map r = this.cloudinary.uploader().upload(product.getFile().getBytes(), ObjectUtils.asMap(
                        "resource_type","auto"
                ));
                String img = (String) r.get("secure_url");
                product.setImage(img);
                 return  this.productRepository.addOrUpdate(product);
               } catch (IOException ex) {
                Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
               return false;
        }

}
    

