package com.codeup.blog.repositories;

import com.codeup.blog.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
//
//    @Query("from User user where user.id like ?1")
//    User getUserById(long id);
}
