package com.example.giraexam.service;

import com.example.giraexam.model.entity.TaskEntity;
import com.example.giraexam.model.service.TaskServiceModel;
import com.example.giraexam.model.view.TaskViewModel;

import java.util.List;

public interface TaskService {
    void addTask(TaskServiceModel map);

    List<TaskViewModel> findAllTasksOrderByDueDate();

    void makeProgress(Long id);

}
