/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.service.Impl;


import com.nhuttran.pojos.User;
import com.nhuttran.repository.UserRepository;
import com.nhuttran.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
     @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public boolean addUser(User user) {
        String password = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(password));
        user.setUserRole(User.USER);
        return userRepository.addUser(user);
    }

    @Override
    public List<User> getUsers(String username) {
       return userRepository.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUsers(username);
        if(users.isEmpty()){
            throw new UsernameNotFoundException("Khong tim thay ten dang nhap !!");
        }
        User user = users.get(0);
        Set<GrantedAuthority> authorities =  new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserRole()));
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
    
}
