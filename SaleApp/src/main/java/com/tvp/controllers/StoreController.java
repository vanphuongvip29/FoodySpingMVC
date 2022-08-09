/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tvp.pojo.Store;
import com.tvp.service.CommentStoreService;

import com.tvp.service.StoreService;
import com.tvp.validator.StoreNameValidator;
import com.tvp.validator.WebAppValidator;
import java.io.IOException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tran van phuong
 */
@Controller
public class StoreController {
    
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private StoreService storeService;
    
    @Autowired
    private CommentStoreService commentStoreService;

    
    @GetMapping("/stores/{storeId}")
    public String storefood(Model model,@PathVariable(value = "storeId") int storeId, 
            @RequestParam(required = false) Map<String, String> params){
        
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("store", this.storeService.getStoreById(storeId));
        
        model.addAttribute("commentStore", this.commentStoreService.getCommentsByStoreId(storeId, page));
        model.addAttribute("commentCounter", this.commentStoreService.CountComment(storeId));
        
        

        return "store-food";
    }
    
    

}
