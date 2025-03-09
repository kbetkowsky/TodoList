package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String title;
    private boolean isDone;
    private String createdAt;

    public Task() {
    }

    public String isComplete() {
        return isDone ? "[X]" : "[ ]";
    }

    public Task(String title) {
        this.title = title;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
