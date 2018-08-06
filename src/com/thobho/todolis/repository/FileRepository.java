package com.thobho.todolis.repository;

import com.thobho.todolis.model.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileRepository implements TaskRepository {

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
        try {
            FileWriter fileWriter = new FileWriter(sourceFile);
            fileWriter.write(task.getShortInfo());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
