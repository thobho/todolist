package com.thobho.todolis.view;

import com.thobho.todolis.model.Task;
import com.thobho.todolis.repository.TaskRepository;

public interface View {

    void setupRepository(TaskRepository taskRepository);

    void saveTask();

    void displayTasks();

}
