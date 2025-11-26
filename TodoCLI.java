// TodoCLI.java
// Simple Command Line To-Do List Application

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    boolean completed;

    Task(String title) {
        this.title = title;
        this.completed = false;
    }

    void markDone() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[✓] " : "[ ] ") + title;
    }
}

public class TodoCLI {
    private static ArrayList<Task> taskList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        while (true) {
            printMenu();
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTaskDone();
                case 4 -> deleteTask();
                case 5 -> {
                    System.out.println("Goodbye! 👋");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== TO-DO LIST MENU =====");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Done");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String title = sc.nextLine();
        taskList.add(new Task(title));
        System.out.println("✅ Task added!");
    }

    private static void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        System.out.println("\nYour Tasks:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i));
        }
    }

    private static void markTaskDone() {
        viewTasks();
        if (taskList.isEmpty()) return;

        System.out.print("Enter task number to mark as done: ");
        int index = sc.nextInt() - 1;

        if (index >= 0 && index < taskList.size()) {
            taskList.get(index).markDone();
            System.out.println("✅ Task marked as done!");
        } else {
            System.out.println("❌ Invalid task number.");
        }
    }

    private static void deleteTask() {
        viewTasks();
        if (taskList.isEmpty()) return;

        System.out.print("Enter task number to delete: ");
        int index = sc.nextInt() - 1;

        if (index >= 0 && index < taskList.size()) {
            taskList.remove(index);
            System.out.println("🗑️ Task deleted!");
        } else {
            System.out.println("❌ Invalid task number.");
        }
    }
}
