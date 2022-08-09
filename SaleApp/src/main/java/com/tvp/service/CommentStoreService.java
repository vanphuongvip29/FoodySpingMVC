/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tvp.service;

import com.tvp.pojo.FollowRating;
import com.tvp.pojo.User;
import java.util.List;

/**
 *
 * @author tran van phuong
 */
public interface CommentStoreService {
    List<FollowRating> getCommentsByStoreId(int storeId, int page);
    long CountComment(int storeId);
    FollowRating addComment(String content, int storeId, User creator);
}
