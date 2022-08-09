/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tvp.repository;

import com.tvp.pojo.FollowRating;
import java.util.List;

/**
 *
 * @author tran van phuong
 */
public interface CommentStoreRepository {
    List<FollowRating> getCommentsByStoreId(int storeId, int page);
    long CountComment(int storeId);
    
    FollowRating addComment(FollowRating c);
}
