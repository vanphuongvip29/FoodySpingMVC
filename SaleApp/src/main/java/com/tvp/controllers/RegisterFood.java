/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.controllers;

import com.cloudinary.Cloudinary;
import com.tvp.pojo.Food;
import com.tvp.pojo.Store;
import com.tvp.pojo.User;
import com.tvp.service.StoreService;
import com.tvp.service.UserService;
import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author tran van phuong
 */

@Controller
public class RegisterFood {
    
    @Autowired
    private Cloudinary cloudinary;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private StoreService storeService;
    
    @GetMapping("/store/registerFood")
    public String listFood(Model model, HttpSession session) {
        
        User u = (User) session.getAttribute("currentUser");
        
        
//        model.addAttribute("food", new Food());
        
        
        
        model.addAttribute("user", this.userService.getUserById(8));
        
        model.addAttribute("store", this.storeService.getStoreById(17));
        
        return "register-food";
    }
//    @PostMapping("/store/registerFood")
//    public String addFood(Model model, 
//            HttpSession session) {
//        
// 
//        User u = (User) session.getAttribute("currentUser");
//        
//        if(u !=null)
//        {
//            model.addAttribute("user", this.userService.getUserById(u.getId()));
//    }
//        return "register-food";
//    }
}
