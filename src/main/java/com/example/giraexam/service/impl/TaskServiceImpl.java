package com.example.giraexam.service.impl;

import com.example.giraexam.model.entity.ProgressEnum;
import com.example.giraexam.model.entity.TaskEntity;
import com.example.giraexam.model.service.TaskServiceModel;
import com.example.giraexam.model.view.TaskViewModel;
import com.example.giraexam.repository.TaskRepository;
import com.example.giraexam.service.ClassificationService;
import com.example.giraexam.service.TaskService;
import com.example.giraexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final ClassificationService classificationService;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, UserService userService, ClassificationService classificationService) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.classificationService = classificationService;
    }

    @Override
    public void addTask(TaskServiceModel map) {
        TaskEntity taskEntity = modelMapper.map(map, TaskEntity.class);
        taskEntity
                .setUser(userService.findUser())
                .setProgress(ProgressEnum.OPEN)
                        .setClassification(classificationService.findClassificationEnum(map.getClassification()));

        taskRepository.save(taskEntity);
    }

    @Override
    public List<TaskViewModel> findAllTasksOrderByDueDate() {

        return taskRepository
                .findAllByOrderByDueDate()
                .stream()
                .map(taskEntity -> modelMapper.map(taskEntity, TaskViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void makeProgress(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElse(null);
        switch (taskEntity.getProgress().name()) {
            case "OPEN": taskEntity.setProgress(ProgressEnum.IN_PROGRESS);
            break;
            case "IN_PROGRESS": taskEntity.setProgress(ProgressEnum.COMPLETED);
            break;
            case "COMPLETED": taskRepository.delete(taskEntity);
                return;
        }
        taskRepository.save(taskEntity);
    }

}
