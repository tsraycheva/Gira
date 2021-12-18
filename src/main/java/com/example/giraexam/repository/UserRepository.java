package com.example.giraexam.repository;

import com.example.giraexam.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserEntityByEmailAndPassword(String email, String password);
    Optional<UserEntity> findUserEntityById(Long id);
}
