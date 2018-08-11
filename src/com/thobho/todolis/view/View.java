package com.thobho.todolis.view;

import com.thobho.todolis.model.Task;
import com.thobho.todolis.repository.TaskRepository;

import java.util.function.Predicate;

public interface View {

    void setupRepository(TaskRepository taskRepository);

    void saveTask();

    void displayTasks(Predicate<Task> taskPredicate);

}
