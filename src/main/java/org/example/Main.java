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
                    System.out.println("Wybierz priorytet zadania: " +
                            "1 - NISKI, 2 - SREDNI, 3 - WYSOKI");
                    int priorityChoice = scanner.nextInt();
                    scanner.nextLine();

                    Priority priority = switch (priorityChoice) {
                        case 1 -> Priority.NISKI;
                        case 2 -> Priority.SREDNI;
                        case 3 -> Priority.WYSOKI;
                        default -> Priority.SREDNI;
                    };

                    taskManager.addTask(title, priority);
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