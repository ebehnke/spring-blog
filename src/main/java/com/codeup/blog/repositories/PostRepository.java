package com.codeup.blog.repositories;

import com.codeup.blog.models.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    //List<Post> findAll();
    //Post findOne(Long id);
    //void save(Post post);
    //void delete(Post post);

    @Query("from Post post where post.id like ?1")
    Post getPostById(long id);


//    @Modifying
    @Transactional
//    @Query("delete from Post post where post.id = ?1")
    void deleteById(long id);


}
