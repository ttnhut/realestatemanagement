/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.service.Impl;

import com.nhuttran.pojos.Product;
import com.nhuttran.repository.CrawlerRepository;
import com.nhuttran.service.CrawlerService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Asus
 */
@Service
public class CrawlerServiceImpl implements CrawlerService{
    @Autowired
    private CrawlerRepository crawlerRepository;
    @Override
    public List<Product> crawData(String keyword) {
       return crawlerRepository.crawData(keyword);
    }

    @Override
    public boolean addDataByCrawing(List<Product> productList) {
        return crawlerRepository.addDataByCrawing(productList);
    }
    
}
