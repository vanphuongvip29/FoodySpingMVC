/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tvp.repository;

import com.tvp.pojo.Store;
import java.util.List;

/**
 *
 * @author tran van phuong
 */
public interface StoreRepository {
    List<Store> getStore(String kw, int page);
    long countStore();
    
    Store getStoreById(int storeId);
    
    boolean addOrUpdate(Store store);
}
