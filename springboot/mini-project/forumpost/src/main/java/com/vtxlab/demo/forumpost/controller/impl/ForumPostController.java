package com.vtxlab.demo.forumpost.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.forumpost.controller.PostControllerInterface;
import com.vtxlab.demo.forumpost.entity.Post;
import com.vtxlab.demo.forumpost.exception.response.ContentLengthUnavailable;
import com.vtxlab.demo.forumpost.exception.response.OutOfIndex;
import com.vtxlab.demo.forumpost.exception.response.TitleLengthUnavailable;
import com.vtxlab.demo.forumpost.service.PostServiceInterface;

@RestController
@RequestMapping(value="api/v1")
public class ForumPostController implements PostControllerInterface{

  @Autowired
  PostServiceInterface postService;

  @Override
  public ResponseEntity<List<Post>> getList() { 
    return ResponseEntity.ok().body(postService.getList());
  }

  @Override
  public ResponseEntity<Post> getListByIndex(Long index) throws OutOfIndex{
    return ResponseEntity.ok().body(postService.getListByIndex(index));
  }

  @Override
  public ResponseEntity<List<Post>> getListByTitle(String title){
    return ResponseEntity.ok().body(postService.getListByTitle(title));
  }

  @Override
  public ResponseEntity<Post> addPost(String title, String content) throws NullPointerException, TitleLengthUnavailable, ContentLengthUnavailable{
    return ResponseEntity.ok().body(postService.addPost(title,content));
  }

  @Override
  public ResponseEntity<String> deletePostByIndex(Long index) throws OutOfIndex{
    return ResponseEntity.ok().body(postService.deletePostByIndex(index));
  }

  @Override
  public ResponseEntity<List<Post>> selfGetPost(String content) {
    return ResponseEntity.ok().body(postService.selfGetPost(content));
  }

  
}
