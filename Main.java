import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.loadData();
        manager.run();
        manager.saveData();
    }
}
