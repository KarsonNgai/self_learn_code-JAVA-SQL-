package com.vtxlab.demo.forumpost.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.vtxlab.demo.forumpost.entity.Post;
import com.vtxlab.demo.forumpost.exception.response.ContentLengthUnavailable;
import com.vtxlab.demo.forumpost.exception.response.OutOfIndex;
import com.vtxlab.demo.forumpost.exception.response.TitleLengthUnavailable;
import com.vtxlab.demo.forumpost.repository.PostRepository;
import com.vtxlab.demo.forumpost.service.PostServiceInterface;

@Service
@Qualifier(value = "ForumPostService")
public class ForumPostService implements PostServiceInterface{
  private int titleLowerLength = 3;
  private int titleUpperLength = 25;
  private int contentLowerLength = 30;
  private int contentUpperLength = 300;

  @Autowired
  PostRepository postRepository;

  @Override
  public List<Post> getList() {
    return postRepository.findAll();
  }

  @Override
  public Post addPost(String title, String content) throws TitleLengthUnavailable,ContentLengthUnavailable{
    if(null==title || null==content)throw new NullPointerException();

    if(titleLowerLength>title.length() || titleUpperLength<title.length()) throw new TitleLengthUnavailable();
    if(contentLowerLength>content.length() || contentUpperLength<content.length()) throw new ContentLengthUnavailable();

    Post post = Post.builder().title(title).content(content).build();
    return postRepository.save(post);
  }

  @Override
  public String deletePostByIndex(Long index) throws OutOfIndex{
    //checking
    this.getListByIndex(index);
    postRepository.deleteById(index);
    return "delete success";
  }

  @Override
  public Post getListByIndex(Long index)throws OutOfIndex {
    if(null == index) throw new NullPointerException();

    if(postRepository.existsById(index))return postRepository.findById(index).get();

    throw new OutOfIndex();
  }
  
  @Override
  public List<Post> getListByTitle(String title){
    return postRepository.findByTitle(title);
  }

  @Override
  public List<Post> selfGetPost(String content) {
    return postRepository.selfFindByContent(content);
  }
}
