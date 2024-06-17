package com.example.devbackend.controller;

import com.example.devbackend.model.Posts;
import com.example.devbackend.repository.PostsRepo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostsRepo postsRepo;

    @GetMapping
    public ResponseEntity<JSONObject> getAllPosts(){
        List<Posts> postsList=new ArrayList<>();
        postsList=postsRepo.findAll();
        JSONObject res=new JSONObject();
        res.put("posts",postsList);
        String message="Result fetched successfully";
        return new ResponseEntity<JSONObject>(res, HttpStatus.OK);
    }
}
