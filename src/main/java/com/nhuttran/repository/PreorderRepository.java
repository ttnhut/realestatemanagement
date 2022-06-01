/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.repository;

import com.nhuttran.pojos.Preorder;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface PreorderRepository {
    boolean addPreOrder(Preorder prev);
    List<Preorder> getPreorders(String kw);
}
