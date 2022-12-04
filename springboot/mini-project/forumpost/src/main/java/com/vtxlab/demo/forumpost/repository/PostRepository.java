package com.vtxlab.demo.forumpost.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vtxlab.demo.forumpost.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
  List<Post> findByTitle(String title);

  @Query(nativeQuery = true, value = "SELECT * FROM posts WHERE Content = ?1")
  List<Post> selfFindByContent(String content);
}
