package com.example.security_1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


public interface

UserRepository extends JpaRepository<User1, Long> {
    @Query(value = "SELECT * FROM user1 u where u.username = ?1", nativeQuery = true)
    public User1 findByUser(String name) ;

}
