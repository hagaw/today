package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface  UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);

    User findByEmail(String email);
    long countByEmail(String email);
    Long countByUsername(String username);


}
