package com.example.giraexam.service;

import com.example.giraexam.model.entity.ClassificationEntity;
import com.example.giraexam.model.entity.ClassificationEnum;

public interface ClassificationService {
    void initClassifications();

    ClassificationEntity findClassificationEnum(ClassificationEnum classification);
}
