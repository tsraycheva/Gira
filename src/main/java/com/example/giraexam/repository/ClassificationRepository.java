package com.example.giraexam.repository;

import com.example.giraexam.model.entity.ClassificationEntity;
import com.example.giraexam.model.entity.ClassificationEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassificationRepository extends JpaRepository<ClassificationEntity, Long> {

    Optional<ClassificationEntity>findClassificationEntityByClassificationName(ClassificationEnum classificationName);


}
