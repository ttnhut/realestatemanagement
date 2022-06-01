/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.controllers;

import com.nhuttran.service.PreorderService;
import com.nhuttran.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Asus
 */
@Controller
public class PreoderController {
    @Autowired
    private PreorderService preorderService;
    @Autowired
    private UserService userService;
    @RequestMapping("/{username}/history")
    public String historyTransaction(Model model , @PathVariable(value = "username") String username){
        model.addAttribute("listTransaction" , preorderService.getPreorders(username));
        model.addAttribute("user", userService.getUsers(username).get(0));
        System.err.println(preorderService.getPreorders(username).size());
        return "history";
    }
    
}
