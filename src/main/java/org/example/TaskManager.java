package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskManager {
    private static final String FILE_NAME = "tasks.json";
    private List<Task> tasks = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    public TaskManager() {
        loadTasks();
    }

    public void addTask(String title, Priority priority) {
        tasks.add(new Task(title, priority));
        saveTasks();
        System.out.println("Dodano zadanie: " + title + " ["
                + priority + "]");
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setDone(true);
            saveTasks();
            System.out.println("Zadanie " + tasks.get(index).getTitle());
        } else {
            System.out.println("Nieprawidlowy numer zadania");
        }
    }

    public void showTasks() {
        System.out.println("\nLista zadan: ");
        int counter = 1;
        for (Task task : tasks) {
            System.out.println(counter + ": " + task.getTitle() + " [" + task.getPriority() +
                    "] " + " " + task.isComplete()
            + " " + tasks.get(counter - 1).getCreatedAt());
            counter++;
        }
    }

    private void saveTasks() {
        try {
            objectMapper.writeValue(new File(FILE_NAME), tasks);
        } catch (IOException e) {
            System.out.println("Blad zapisu: " + e.getMessage());
        }
    }

    private void loadTasks() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try {
                tasks = objectMapper.readValue(file, new TypeReference<List<Task>>() {
                });
            } catch (IOException e) {
                System.out.println("Blad odczytu: " + e.getMessage());
                tasks = new ArrayList<>();
            }
        } else {
            tasks = new ArrayList<>();
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            System.out.println("Usunieto zadanie: " + tasks.get(index).getTitle());
            tasks.remove(index);
            saveTasks();
        } else System.out.println("Nieprawidlowy numer zadania");
    }

    public void showTasksSortedByPrioity() {
        tasks.stream().sorted(Comparator.comparing(Task::getPriority).reversed())
                .forEach(task -> System.out.println(task.isComplete() + " " + task.getTitle() + " ["
                + task.getPriority() + "]"));
    }
}
