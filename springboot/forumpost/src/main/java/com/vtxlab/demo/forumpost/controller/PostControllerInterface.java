package com.vtxlab.demo.forumpost.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.demo.forumpost.entity.Post;
import com.vtxlab.demo.forumpost.exception.response.ContentLengthUnavailable;
import com.vtxlab.demo.forumpost.exception.response.OutOfIndex;
import com.vtxlab.demo.forumpost.exception.response.TitleLengthUnavailable;

public interface PostControllerInterface {
  
  @GetMapping(value="post")
  ResponseEntity<List<Post>> getList();

  @GetMapping(value="post/{index}")
  ResponseEntity<Post> getListByIndex(@PathVariable(value="index") Long index) throws OutOfIndex;

  @GetMapping(value="post/title/{title}")
  ResponseEntity<List<Post>> getListByTitle(@PathVariable(value="title") String title);

  @PostMapping(value="post/{title}/{content}")
  ResponseEntity<Post> addPost(@PathVariable String title,@PathVariable String content) throws NullPointerException, TitleLengthUnavailable, ContentLengthUnavailable;

  @DeleteMapping(value="delete-post")
  ResponseEntity<String> deletePostByIndex(@RequestParam(value="index",defaultValue = "1") Long index) throws OutOfIndex;

  @GetMapping(value="testq/{content}")
  ResponseEntity<List<Post>> selfGetPost(@PathVariable(value="content") String content);
}
