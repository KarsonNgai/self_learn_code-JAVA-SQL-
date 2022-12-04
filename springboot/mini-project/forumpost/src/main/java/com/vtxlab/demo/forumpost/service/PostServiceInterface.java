package com.vtxlab.demo.forumpost.service;

import java.util.List;
import com.vtxlab.demo.forumpost.entity.Post;
import com.vtxlab.demo.forumpost.exception.response.ContentLengthUnavailable;
import com.vtxlab.demo.forumpost.exception.response.OutOfIndex;
import com.vtxlab.demo.forumpost.exception.response.TitleLengthUnavailable;

public interface PostServiceInterface {

  List<Post> getList();

  Post addPost(String title, String content) throws TitleLengthUnavailable, ContentLengthUnavailable;

  String deletePostByIndex(Long index) throws OutOfIndex;

  Post getListByIndex(Long index) throws OutOfIndex;
  
  List<Post> getListByTitle(String title);

  List<Post> selfGetPost(String content);
}
