/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.service.Impl;

import com.nhuttran.pojos.Preorder;
import com.nhuttran.repository.PreorderRepository;
import com.nhuttran.service.PreorderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class PreorderServiceImpl implements PreorderService{
    @Autowired
    private PreorderRepository preorderRepository;

    @Override
    public boolean addPreorder(Preorder prev) {
        return preorderRepository.addPreOrder(prev);
    }

    @Override
    public List<Preorder> getPreorders(String kw) {
        return preorderRepository.getPreorders(kw);
     }

    


}
