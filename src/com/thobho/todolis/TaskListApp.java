package com.thobho.todolis;

import com.thobho.todolis.model.Priority;
import com.thobho.todolis.repository.FileRepository;
import com.thobho.todolis.repository.TaskRepository;
import com.thobho.todolis.view.ConsoleView;
import com.thobho.todolis.view.PriorityPredicate;
import com.thobho.todolis.view.View;

import java.util.Scanner;

public class TaskListApp {
    static Scanner scanner = new Scanner(System.in);

    static TaskRepository taskRepository = new FileRepository();
    static View view = new ConsoleView();

    public static void main(String[] args) {
        view.setupRepository(taskRepository);

        System.out.println("1 - Add task, 2 - print all");


        int action = scanner.nextInt();

        switch (action){
            case 1: view.saveTask();
            break;
            case 2: selectPriority();
            break;
        }
    }

    private static void selectPriority(){
        System.out.println("select priority a - LOW b -..." );
        String next = scanner.next();
        switch (next){
            case "a": view.displayTasks(new PriorityPredicate(Priority.LOW));
                break;
            case "b":  view.displayTasks(new PriorityPredicate(Priority.MEDIUM));
                break;
            case "c":  view.displayTasks(new PriorityPredicate(Priority.HIGH));
                break;
        }
    }

}
