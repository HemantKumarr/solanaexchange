package com.solanaexchange.project.dao;

import com.solanaexchange.project.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query(value = "SELECT * from Users where email = :email", nativeQuery = true)
    Users findByEmail(String email);
}
