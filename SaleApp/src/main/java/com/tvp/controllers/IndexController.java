/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.controllers;

import com.tvp.pojo.Cart;
import com.tvp.pojo.Category;
import com.tvp.pojo.Store;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tvp.service.CategoryService;
import com.tvp.service.StoreService;
import com.tvp.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tran van phuong
 */
@Controller
@ControllerAdvice
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StoreService storeService;

    @ModelAttribute
    public void commonAttrs(Model model, HttpSession session) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("cartCounter", Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam(required = false) Map<String, String> params) {

        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        String cateId = params.get("CateId");
        

        if (cateId == null) {
            model.addAttribute("stores", this.storeService.getStores(kw, page));

        } else {
            Category c = this.categoryService.getCategoryById(Integer.parseInt(cateId));
            model.addAttribute("stores", c.getStoreCollection());

        }

        model.addAttribute("storeCounter", this.storeService.countStore());

        

        return "index";
    }

}
