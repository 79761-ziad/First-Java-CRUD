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

    
}