/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tvp.pojo.Store;
import com.tvp.pojo.User;
import com.tvp.repository.StoreRepository;
import com.tvp.repository.UserRepository;
import com.tvp.service.StoreService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tran van phuong
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private StoreRepository storeRepository;
    
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Store> getStores(String kw, int page) {
        return this.storeRepository.getStore(kw, page);
    }

    @Override
    public long countStore() {
        return this.storeRepository.countStore();
    }

    @Override
    public Store getStoreById(int storeId) {
        return this.storeRepository.getStoreById(storeId);
    }

    @Override
    public boolean addOrUpdate(Store store, User creator) {
        
//        User u = this.userRepository.getUserById(5);
        try {
            
            
            
            Map r = this.cloudinary.uploader().upload(store.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            
            store.setImage((String) r.get("secure_url"));
            
            store.setUserId(creator);
            
        
            return this.storeRepository.addOrUpdate(store);

        } catch (IOException ex) {
            System.err.println("=== ADD STORE ==" + ex.getMessage());
        }

        return false;
    }



}
