package com.thobho.todolis;

import com.thobho.todolis.model.Task;
import com.thobho.todolis.repository.FileRepository;
import com.thobho.todolis.repository.SqlRepository;
import com.thobho.todolis.repository.TaskRepository;
import com.thobho.todolis.view.ConsoleView;
import com.thobho.todolis.view.View;

import java.util.Scanner;

public class TaskListApp {

    static TaskRepository taskRepository = new FileRepository();
    static View view = new ConsoleView();

    public static void main(String[] args) {
        view.setupRepository(taskRepository);




    }

}
