package com.example.giraexam.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class ClassificationEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClassificationEnum classificationName;
    @Column(columnDefinition = "TEXT")
    private String description;


    public ClassificationEntity() {
    }

    public ClassificationEnum getClassificationName() {
        return classificationName;
    }

    public ClassificationEntity setClassificationName(ClassificationEnum classificationName) {
        this.classificationName = classificationName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ClassificationEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
