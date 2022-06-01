/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.controllers;



import com.nhuttran.pojos.Preorder;
import com.nhuttran.pojos.Product;
import com.nhuttran.service.CrawlerService;
import com.nhuttran.service.PreorderService;
import com.nhuttran.service.ProductService;
import com.nhuttran.service.UserService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.jsp.PageContext;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Asus
 */
@Controller
public class ProductController {
    @Autowired
    private PreorderService preorderService;
    @Autowired
    private UserService userService;
    @Autowired
    private CrawlerService crawlerService;
    @Autowired
    private ProductService productService;
    @RequestMapping("/category")
    public String getProduct(Model model ,@RequestParam(required = false) Map<String,String> params){
        
        if(params.get("search")==null){
            model.addAttribute("products",productService.getProducts(params.get("cat")));
        }
        else{
            model.addAttribute("products",productService.getProducts(params.get("search")));
        }
      
        return "product";
    }
    
    @RequestMapping("/admin/addproduct")
    public String addProduct(Model model){
        model.addAttribute("product",new Product());
        return "addproduct";
    }
    
    @PostMapping("/admin/addproduct")
    public String addingProduct(@ModelAttribute(value="product")@Valid Product p,
            BindingResult result){
        if(!result.hasErrors()){
            if(this.productService.addOrUpdate(p)==true)
                return "redirect:/";
        }
            return "addproduct";
        
        
    }
    @GetMapping("/product/{id}")
    public String productOrder(@PathVariable(value = "id") int id , Model model 
          ,@RequestParam(required = false) Map<String,String> key  ){
        String msg ="";
        Preorder prev = new Preorder();
        Product p = productService.getProducts(String.valueOf(id)).get(0);
        prev.setProductId(p);
        prev.setDate(new Date());
        if(key.get("username")!=null){
            com.nhuttran.pojos.User user = userService.getUsers(key.get("username")).get(0);
            prev.setUserId(user);
        }
         if(key.get("allCost")!=null && key.get("cost")!=""){
           msg="Không được nhập trùng" ;  
           model.addAttribute("msg" ,msg);
            return "order";
        }
        if(key.get("allCost")!=null){
            prev.setPrice(p.getPrice());
            
            preorderService.addPreorder(prev);
            msg="Đặt trước toàn bộ thành công";
            model.addAttribute("msg" ,msg);
            return "order";
        }
    
       
        else if(key.get("allCost")==null&&key.get("cost")!=null){
            if((Double.parseDouble(key.get("cost")) == p.getPrice().doubleValue())
                    || (Double.parseDouble(key.get("cost")) > p.getPrice().doubleValue()) ){
                prev.setPrice(p.getPrice());
                msg="Đặt trước toàn bộ thành công";
                preorderService.addPreorder(prev);
            }
            else if(Double.parseDouble(key.get("cost")) < p.getPrice().doubleValue()){
                prev.setPrice(p.getPrice());
                msg="Đặt trước vay ngân hàng thành công";
                preorderService.addPreorder(prev);
                model.addAttribute("lendingPrice",p.getPrice().doubleValue() - Double.parseDouble(key.get("cost")) );
            }
        }
        model.addAttribute("msg" ,msg);
       model.addAttribute("product",p);
        return "order";
    }
    
            
            
            
            @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("products",crawlerService.crawData("nha pho"));
        
        return "test";
    }
}
