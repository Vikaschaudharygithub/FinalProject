import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<String> pendingTasks;
    private String[] completedTasks;
    private final String pendingFile = "tasks.txt";
    private final String completedFile = "completed.txt";

    public TaskManager() {
        pendingTasks = new ArrayList<>();
        completedTasks = new String[0];
    }

    public void loadData() {
        pendingTasks = FileHandler.loadData(pendingFile);
        ArrayList<String> completedList = FileHandler.loadData(completedFile);
        completedTasks = completedList.toArray(new String[0]);
    }

    public void saveData() {
        FileHandler.saveData(pendingTasks, pendingFile);
        FileHandler.saveData(new ArrayList<>(Arrays.asList(completedTasks)), completedFile);
        System.out.println("Data saved. Goodbye!");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Daily Task Organizer ---");
            System.out.println("1. View Pending Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Complete Task");
            System.out.println("4. View Completed Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = InputValidator.getIntInput(scanner);
            switch (choice) {
                case 1: viewPending(); break;
                case 2: addTask(scanner); break;
                case 3: completeTask(scanner); break;
                case 4: viewCompleted(); break;
                case 5: return;
                default: System.out.println("Invalid choice. Try again."); break;
            }
        }
    }

    private void viewPending() {
        System.out.println("\nPending Tasks:");
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            for (int i = 0; i < pendingTasks.size(); i++) {
                System.out.println((i + 1) + ". " + pendingTasks.get(i));
            }
        }
    }

    private void addTask(Scanner scanner) {
        System.out.print("Enter new task: ");
        String task = scanner.nextLine();
        pendingTasks.add(task);
        System.out.println("Task added.");
    }

    private void completeTask(Scanner scanner) {
        if (pendingTasks.isEmpty()) {
            System.out.println("No tasks to complete.");
            return;
        }
        viewPending();
        System.out.print("Enter task number to complete: ");
        int index = InputValidator.getIntInput(scanner) - 1;
        try {
            String task = pendingTasks.remove(index);
            String[] newArray = Arrays.copyOf(completedTasks, completedTasks.length + 1);
            newArray[newArray.length - 1] = task;
            completedTasks = newArray;
            System.out.println("Task completed: " + task);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index. Try again.");
            completeTask(scanner);
        }
    }

    private void viewCompleted() {
        System.out.println("\nCompleted Tasks:");
        if (completedTasks.length == 0) {
            System.out.println("No completed tasks.");
        } else {
            for (int i = 0; i < completedTasks.length; i++) {
                System.out.println((i + 1) + ". " + completedTasks[i]);
            }
        }
    }
}
