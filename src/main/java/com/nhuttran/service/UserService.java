/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.service;


import com.nhuttran.pojos.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Asus
 */
public interface UserService extends UserDetailsService {
    boolean addUser(User user);
    List<User> getUsers(String username);
}
