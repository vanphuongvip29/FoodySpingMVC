/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.controllers;

import com.tvp.pojo.User;
import com.tvp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author tran van phuong
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userDetailsService;
    
    
    
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user",new User());
        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model,@ModelAttribute(value = "user") User user){
        String errMsg = "";
        
        
//        System.out.println(user.getUserRole());
//        if(user.getUserRole()=="ROLE_USER")
//            user.setActive(1);
//        else
//            user.setActive(0);
        
        if(user.getPassword().equals(user.getConfirmPassword())){
            if(this.userDetailsService.addUser(user)==true)
                return "redirect:/login";
            else
                errMsg = "Da co loi";
        }else
            errMsg = "Mat Khau Khong Khop";
        
        model.addAttribute("errMsg", errMsg);
        
        return "register";
    }
}
