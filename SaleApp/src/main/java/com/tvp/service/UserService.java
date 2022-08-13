/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tvp.service;

import com.tvp.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author tran van phuong
 */
public interface UserService extends UserDetailsService{
    boolean addUser(User user);
    List<User> getUsers(String username);
    User getUserById(int userId);
    
   
}
