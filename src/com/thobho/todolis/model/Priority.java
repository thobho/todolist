package com.thobho.todolis.model;

public enum Priority {
    HIGIH("Do it immediatly!!!"),
    MEDIUM("Consider doing this!"),
    LOW("Not so important...");

    private String description;

    Priority(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
