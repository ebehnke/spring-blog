package com.codeup.blog;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    //List<Post> findAll();
    //Property findOne(Long id);
    //void save(Post property);
    //void delete(Post property);
}
