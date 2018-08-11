package com.thobho.todolis.repository;

import com.thobho.todolis.model.Task;

import java.util.List;

public interface TaskRepository {
    void setupRepository(String source);
    void saveTask(Task task);
    List<Task> getAll();
}
