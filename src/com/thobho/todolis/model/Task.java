package com.thobho.todolis.model;

import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

public class Task {

    private static int idCounter = 0;

    private int id;
    private String description;
    private Priority priority;
    private LocalDateTime creationDate;
    private LocalDateTime deadLine;

    public Task(String description, Priority priority, LocalDateTime deadLine) {
        this.id = idCounter;
        idCounter++;
        this.description = description;
        this.priority = priority;
        this.creationDate = LocalDateTime.now();
        this.deadLine = deadLine;
    }

    public Task(int id, String description, Priority priority, LocalDateTime deadLine){
        this(description, deadLine);
        this.priority = priority;
        this.id = id;
    }

    public Task(String description, LocalDateTime deadLine) {
        this(description, Priority.LOW, deadLine);
    }

    public Task(String description) {
        this(description, Priority.LOW, LocalDateTime.now().plusDays(5));
    }

    public String getShortInfo() {
        return String.format("%d , %s , %s , %s%n",
                id, priority.toString(), this.description, deadLine.toString());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(description, task.description) &&
                priority == task.priority &&
                Objects.equals(creationDate, task.creationDate) &&
                Objects.equals(deadLine, task.deadLine);
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, priority, creationDate, deadLine);
    }
}
