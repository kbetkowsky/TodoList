package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Dodaj zadanie, " +
                    "2. Pokaż zadania, 3. Oznacz jako ukończone," +
                    " 4. Wyjdź");
            int number = scanner.nextInt();
            scanner.nextLine();

            switch (number) {
                case 1 -> {
                    System.out.println("Podaj tytul zadania: ");
                    String title = scanner.nextLine();
                    taskManager.addTask(title);
                }
                case 2 -> {
                    taskManager.showTasks();
                }
                case 3 -> {
                    System.out.println("Podaj numer zadania do ukonczenia: ");
                    int index = scanner.nextInt();
                    taskManager.completeTask(index - 1);
                }
                case 4 -> {
                    return;
                }
                case 5 -> {
                    System.out.println("Podaj numer zadania do usunięcia: ");
                    int index = scanner.nextInt();
                    taskManager.removeTask(index - 1);
                }
                default -> System.out.println("Nieprawidlowy wybor");
            }
        }
        }
    }