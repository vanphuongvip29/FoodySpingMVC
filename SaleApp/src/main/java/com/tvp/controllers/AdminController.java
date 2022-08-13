/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tran van phuong
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @GetMapping("/category-stats")
    public String cateStats(){
        return "category-state";
    }
}
