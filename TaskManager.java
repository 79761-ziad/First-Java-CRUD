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
    
    }

    // ///////////// READ /////////////
    private static void listTasks() {
  
    }

    // ///////////// UPDATE /////////////
    private static void updateTask() {
    
    }

    // ///////////// DELETE /////////////
    private static void deleteTask() {
    
    }

    // ///////////// Helpers /////////////
    private static Task findTaskById() {
    
    }

    private static boolean isValidStatus(String status) {
        return status.equals("TODO") || status.equals("DOING") || status.equals("DONE");
    }
}