 
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.controllers;

import com.tvp.pojo.FollowRating;
import com.tvp.pojo.User;
import com.tvp.service.CommentStoreService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tran van phuong
 */
@RestController
public class ApiCommentController {

    @Autowired
    private CommentStoreService commentStoreService;

    @PostMapping(path = "/api/add-comment", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<FollowRating> addComment(@RequestBody Map<String, String> params, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");

        if(u != null)
            try {
                String content = params.get("content");
                int storeId = Integer.parseInt(params.get("storeId"));

                FollowRating c = this.commentStoreService.addComment(content, storeId, u);

                return new ResponseEntity<>(c, HttpStatus.CREATED);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
