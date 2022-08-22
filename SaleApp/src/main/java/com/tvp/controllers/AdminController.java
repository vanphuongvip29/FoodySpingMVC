/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.controllers;

import com.tvp.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tran van phuong
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/category-stats")
    public String cateStats(Model model) {
        model.addAttribute("cateStats", this.statsService.cateStats());

        return "category-stats";
    }

    @GetMapping("/store-stats")
    public String storeStats(Model model, @RequestParam(required = false) Map<String, String> params) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        

        Date fromDate = null, toDate = null;

        try {

            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        model.addAttribute("storeStats", this.statsService.storeStats(fromDate, toDate));

        return "store-stats";
    }
    
    
    @GetMapping("/store-month-stats")
    public String storeMonthStats(Model model){
        
        model.addAttribute("storeMonthStats", this.statsService.storeMonthStats());
        
        return "store-month-stats";
    }
}
