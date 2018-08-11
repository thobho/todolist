package com.thobho.todolis.repository;

import com.thobho.todolis.model.Priority;
import com.thobho.todolis.model.Task;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileRepository implements TaskRepository {

    private static final String FILE_SEPARATOR = ",";
    private File sourceFile;

    public FileRepository() {
        setupRepository("todo.txt");
    }

    @Override
    public void setupRepository(String source) {
        sourceFile = new File(source);
        handleFileNotFound(sourceFile);
    }

    @Override
    public void saveTask(Task task) {

        try (FileWriter fileWriter = new FileWriter(sourceFile)) {
            fileWriter.write(task.getShortInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> getAll() {
        List<Task> tasks = new ArrayList<>();
        try (Scanner scanner = new Scanner(sourceFile)) {
            while (scanner.hasNext()) {
                tasks.add(parseLine(scanner.nextLine()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    List<Task> getAll2(){
        return Stream.generate(()->generateTask()).collect(Collectors.toList());
    }

    private Task generateTask(){
        return new Task("", null, null);
    }

    /*
    Może być w osobnym interfejsie.
     */
    private Task parseLine(String string) {
        String[] split = string.split((FILE_SEPARATOR));

        for (int i = 0; i < split.length; i++) {
            
           split[i] = split[i].trim();
        }


        int id = Integer.parseInt(split[0]);
        Priority priority = Priority.valueOf(split[1]);
        String descriptioin = split[2];
        LocalDateTime date = LocalDateTime.parse(split[3]);

        return new Task(id, descriptioin, priority, date);


    }

    private void handleFileNotFound(File file) {
        if (!file.exists()) {
            System.out.println("Can not find file. File was created...");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
