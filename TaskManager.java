import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 
public class TaskManager {

    // ///////////// Entity /////////////
    static class Task {
        private static int nextId = 1;

        private final int id;
        private String title;
        private String status; // e.g. "TODO", "DOING", "DONE"

        Task(String title, String status) {
            this.id = nextId++;
            this.title = title;
            this.status = status;
        }

        int getId() { return id; }
        String getTitle() { return title; }
        String getStatus() { return status; }
        void setTitle(String title) { this.title = title; }
        void setStatus(String status) { this.status = status; }

        @Override
        public String toString() {
            return String.format("[%d] %-30s (%s)", id, title, status);
        }
    }

    // ///////////// Storage /////////////
    private static final List<Task> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    // ///////////// Main menu loop /////////////
    public static void main(String[] args) {
        System.out.println("=== Task Manager (Console CRUD) ===");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> createTask();
                case "2" -> listTasks();
                case "3" -> updateTask();
                case "4" -> deleteTask();
                case "5" -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("--- Menu ---");
        System.out.println("1. Create task");
        System.out.println("2. List tasks");
        System.out.println("3. Update task");
        System.out.println("4. Delete task");
        System.out.println("5. Exit");
        System.out.print("Choose: ");
    }

    // ///////////// CREATE /////////////
    private static void createTask() {
              private static void createTask() {
        System.out.print("Title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }

        System.out.print("Status (TODO/DOING/DONE): ");
        String status = scanner.nextLine().trim().toUpperCase();
        if (!isValidStatus(status)) {
            System.out.println("Invalid status. Task not created.");
            return;
        }

        Task task = new Task(title, status);
        tasks.add(task);
        System.out.println("Created: " + task);
    }
    }

   // ///////////// READ /////////////
    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }
        System.out.println("--- Tasks ---");
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    // ///////////// UPDATE /////////////
    private static void updateTask() {
        Task task = findTaskById();
        if (task == null) return;

        System.out.print("New title (leave blank to keep '" + task.getTitle() + "'): ");
        String title = scanner.nextLine().trim();
        if (!title.isEmpty()) {
            task.setTitle(title);
        }

        System.out.print("New status (leave blank to keep '" + task.getStatus() + "'): ");
        String status = scanner.nextLine().trim().toUpperCase();
        if (!status.isEmpty()) {
            if (isValidStatus(status)) {
                task.setStatus(status);
            } else {
                System.out.println("Invalid status. Status unchanged.");
            }
        }

        System.out.println("Updated: " + task);
    }


 // ///////////// DELETE /////////////
    private static void deleteTask() {
        Task task = findTaskById();
        if (task == null) return;

        System.out.print("Delete '" + task.getTitle() + "'? (y/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (confirm.equals("y")) {
            tasks.remove(task);
            System.out.println("Deleted task " + task.getId() + ".");
        } else {
            System.out.println("Cancelled.");
        }
    }

    // ///////////// Helpers /////////////
    private static Task findTaskById() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return null;
        }
        System.out.print("Task ID: ");
        String input = scanner.nextLine().trim();
        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
            return null;
        }
        for (Task t : tasks) {
            if (t.getId() == id) return t;
        }
        System.out.println("No task with ID " + id + ".");
        return null;
    }

    private static boolean isValidStatus(String status) {
        return status.equals("TODO") || status.equals("DOING") || status.equals("DONE");
    }
}