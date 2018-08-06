package com.thobho.todolis.repository;

import com.thobho.todolis.model.Task;

public interface TaskRepository {
    void setupRepository(String source);
    void saveTask(Task task);
}
