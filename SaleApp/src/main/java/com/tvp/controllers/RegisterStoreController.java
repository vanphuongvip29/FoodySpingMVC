/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tvp.pojo.Store;
import com.tvp.pojo.User;
import com.tvp.service.StoreService;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author tran van phuong
 */
@Controller
public class RegisterStoreController {


    
    @Autowired
    private StoreService storeService;

    @GetMapping("/store/registerStore")
    public String listStore(Model model) {

        model.addAttribute("store", new Store());
        return "register-store";
    }

    @PostMapping("/store/registerStore")
    public String addstore(Model model, @ModelAttribute(value = "store") @Valid Store store,
            BindingResult result ,HttpSession session) {
        
        User u = (User) session.getAttribute("currentUser");
        
        if (!result.hasErrors()) {
            if(this.storeService.addOrUpdate(store,u)==true)
                return "redirect:/";
            else
                model.addAttribute("errMsg", "Something wrong!!");
        }
        
        return "register-store";
    }

}
