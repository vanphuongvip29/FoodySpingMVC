/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tvp.repository;

import com.tvp.pojo.User;
import java.util.List;

/**
 *
 * @author tran van phuong
 */
public interface UserRepository {
    boolean addUser(User user);
    List<User> getUsers(String username);
    
    User getUserById(int userId);
    
    
}
