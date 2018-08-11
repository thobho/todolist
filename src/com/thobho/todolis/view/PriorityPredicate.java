package com.thobho.todolis.view;

import com.thobho.todolis.model.Priority;
import com.thobho.todolis.model.Task;

import java.util.function.Predicate;

public class PriorityPredicate implements Predicate<Task> {

    private Priority testedPriority;

    public PriorityPredicate(Priority priority) {
        testedPriority = priority;
    }

    @Override
    public boolean test(Task task) {
        return task.getPriority().equals(testedPriority);
    }
}
