package com.example.giraexam.service.impl;

import com.example.giraexam.model.entity.ClassificationEntity;
import com.example.giraexam.model.entity.ClassificationEnum;
import com.example.giraexam.repository.ClassificationRepository;
import com.example.giraexam.service.ClassificationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;
    private final ModelMapper modelMapper;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository, ModelMapper modelMapper) {
        this.classificationRepository = classificationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initClassifications() {
        if(this.classificationRepository.count() == 0) {
            Arrays.stream(ClassificationEnum.values())
                    .forEach(classificationEnum -> {
                        ClassificationEntity classification = new ClassificationEntity();
                        classification.setClassificationName(classificationEnum)
                                .setDescription("Description for " + classificationEnum.name());
                      classificationRepository.save(classification);
                    });
        }
    }

    @Override
    public ClassificationEntity findClassificationEnum(ClassificationEnum classification) {
        return classificationRepository.findClassificationEntityByClassificationName(classification)
                .orElse(null);
    }
}
