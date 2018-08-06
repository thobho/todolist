package com.thobho.todolis;

import com.thobho.todolis.model.Task;
import com.thobho.todolis.repository.FileRepository;

import java.util.Scanner;

public class TaskListApp {

    private static Scanner scanner = new Scanner(System.in);
    static FileRepository fileRepository = new FileRepository();

    public static void main(String[] args) {
        createTask();
    }

    static void createTask(){
        System.out.println("Create new task: \n Write description");
        String description = scanner.nextLine();
        Task task = new Task(description);
        fileRepository.saveTask(task);
    }
}
