/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 *
 * @author Asus
 */
@Configuration
public class TilesConfig {
    
    @Bean
    public UrlBasedViewResolver viewResolver(){
        UrlBasedViewResolver u = new UrlBasedViewResolver();
        u.setViewClass(TilesView.class);
        u.setOrder(-2);
        return u;
    }
    
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer t = new TilesConfigurer();
        t.setDefinitions("/WEB-INF/tiles.xml");
        t.setCheckRefresh(true);
        return t;
    }
}
