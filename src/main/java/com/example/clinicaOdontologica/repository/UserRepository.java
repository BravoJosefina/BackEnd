package com.example.clinicaOdontologica.repository;

import com.example.clinicaOdontologica.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("from User u where u.name = :name")
    Optional<User> getUserByName(@Param("name")String name);
}
