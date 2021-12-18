package com.example.giraexam.model.binding;

import com.example.giraexam.model.entity.ClassificationEnum;
import com.example.giraexam.model.entity.ProgressEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TaskAddBindingModel {

    @Size(min = 3, max = 20, message = "Task name must be between 3 and 20 characters")
    private String name;
    @Size(min = 5, message = "Description must be more than 5 characters")
    private String description;
    @NotNull
    @FutureOrPresent(message = "The date must not be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @NotNull
    private ClassificationEnum classification;

    public TaskAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public TaskAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskAddBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationEnum getClassification() {
        return classification;
    }

    public TaskAddBindingModel setClassification(ClassificationEnum classification) {
        this.classification = classification;
        return this;
    }
}
