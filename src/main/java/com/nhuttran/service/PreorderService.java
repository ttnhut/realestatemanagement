/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.service;

import com.nhuttran.pojos.Preorder;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface PreorderService {
    boolean addPreorder(Preorder prev);
    List<Preorder> getPreorders(String kw);
}
