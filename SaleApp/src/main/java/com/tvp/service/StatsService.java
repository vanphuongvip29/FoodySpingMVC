/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tvp.service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author tran van phuong
 */
public interface StatsService {
    List<Object> cateStats();
    List<Object> storeStats( Date fromDate, Date toDate);
    List<Object> storeMonthStats();

}
