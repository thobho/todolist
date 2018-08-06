package com.thobho.todolis.model;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<Task> allTasks;

    public TaskList(List<Task> allTasks) {
        this.allTasks = new ArrayList<>();
    }

    public void addTask(Task newTask){
        allTasks.add(newTask);
    }
}
