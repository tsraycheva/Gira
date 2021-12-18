package com.example.giraexam.model.view;

import com.example.giraexam.model.entity.ClassificationEnum;
import com.example.giraexam.model.entity.ProgressEnum;
import com.example.giraexam.model.service.UserServiceModel;

import java.time.LocalDate;

public class TaskViewModel {

    private Long id;
    private String name;
    private String description;
    private ProgressEnum progress;
    private LocalDate dueDate;
    private ClassificationEnum classification;
    private UserServiceModel user;
    private String classColor;

    public TaskViewModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public TaskViewModel setProgress(ProgressEnum progress) {
        this.progress = progress;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskViewModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationEnum getClassification() {
        return classification;
    }

    public TaskViewModel setClassification(ClassificationEnum classification) {
        this.classification = classification;
        return this;
    }

    public UserServiceModel getUser() {
        return user;
    }

    public TaskViewModel setUser(UserServiceModel user) {
        this.user = user;
        return this;
    }

    public String getClassColor() {
        return classColor;
    }

    public TaskViewModel setClassColor() {
        this.classColor = "classifications " + this.getClassification().name();
        return this;
    }
}
