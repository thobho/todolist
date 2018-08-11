package com.thobho.todolis.view;

import com.thobho.todolis.model.Priority;
import com.thobho.todolis.model.Task;
import com.thobho.todolis.repository.FileRepository;
import com.thobho.todolis.repository.TaskRepository;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ConsoleView implements View {

    private static Scanner scanner = new Scanner(System.in);
    static TaskRepository fileRepository;

    @Override
    public void setupRepository(TaskRepository taskRepository) {
        fileRepository = taskRepository;
    }

    @Override
    public void saveTask() {
        System.out.println("Create new task: \n Write description");
        String description = scanner.nextLine();
        Task task = new Task(description);
        fileRepository.saveTask(task);
    }

    @Override
    public void displayTasks(Predicate<Task> priorityPredicate) {
        List<Task> all = fileRepository.getAll();
        for (Task task : all) {
            if (priorityPredicate.test(task)) {
                System.out.println(task.getShortInfo());
            }
        }

//        all.stream()
//                .filter(priorityPredicate)
//                .forEach(task -> System.out.println(task));
    }
}
