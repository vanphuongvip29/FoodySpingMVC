/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.controllers;

import com.cloudinary.Cloudinary;
import com.tvp.pojo.Food;
import com.tvp.pojo.Store;
import com.tvp.pojo.User;
import com.tvp.service.FoodService;
import com.tvp.service.StoreService;
import com.tvp.service.UserService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tran van phuong
 */
@Controller
public class FoodController {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private UserService userService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private FoodService foodService;

    @GetMapping("/store/registerFood/{storeId}")
    public String Food(Model model, HttpSession session,
            @PathVariable(value = "storeId") int storeId) {
        
        model.addAttribute("food", new Food());
        model.addAttribute("store", this.storeService.getStoreById(storeId));

        return "food";
    }

    @PostMapping("/store/registerFood/{storeId}")
    public String addfood(Model model, @ModelAttribute(value = "food") @Valid Food food,
            BindingResult result,
            @PathVariable(value = "storeId") int storeId) {
    

        
//        Store s = this.storeService.getStoreById(storeId);
        
//        model.addAttribute("store", this.storeService.getStoreById(storeId));
        
        if (!result.hasErrors()) {
            if (this.foodService.addOrUpdate(food, storeId) == true) {
                return "redirect:/store/registerFood";
            } else {
                model.addAttribute("errMsg", "Something wrong!!");
            }
        }

      
       return "food";
    }
    

}
