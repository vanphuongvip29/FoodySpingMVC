/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.service.impl;

import com.tvp.repository.StatsRepository;
import com.tvp.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tran van phuong
 */
@Service
public class StatsServiceImpl implements StatsService{

    @Autowired
    private StatsRepository statsRepository;
    
    @Override
    public List<Object> cateStats() {
        return this.statsRepository.cateStats();
    }

    @Override
    public List<Object> storeStats(Date fromDate, Date toDate) {
        return this.statsRepository.storeStats( fromDate, toDate);
    }

    @Override
    public List<Object> storeMonthStats() {
        return this.statsRepository.storeMonthStats();
    }
    
}
