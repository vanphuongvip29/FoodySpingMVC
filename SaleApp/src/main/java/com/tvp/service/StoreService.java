/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tvp.service;

import com.tvp.pojo.Store;
import com.tvp.pojo.User;
import java.util.List;

/**
 *
 * @author tran van phuong
 */
public interface StoreService {
    List<Store> getStores(String kw, int page);
    long countStore();
    
    Store getStoreById(int storeId);
    
    boolean addOrUpdate(Store store, User creator);
}
