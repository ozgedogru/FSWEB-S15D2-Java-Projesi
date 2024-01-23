import enums.Priority;
import enums.Status;
import model.Task;
import model.TaskData;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        TaskData taskData = new TaskData();

        Task annsTask1 = new Task("ProjectA", "Task 1", "Ann", Priority.HIGH, Status.IN_PROGRESS);
        Task annsTask2 = new Task("ProjectB", "Task 2", "Ann", Priority.MED, Status.ASSIGNED_IN);
        taskData.getAnnsTasks().addAll(Set.of(annsTask1, annsTask2));

        Task bobsTask1 = new Task("ProjectA", "Task 3", "Bob", Priority.LOW, Status.IN_QUEUE);
        Task bobsTask2 = new Task("ProjectC", "Task 4", "Bob", Priority.HIGH, Status.ASSIGNED_IN);
        taskData.getBobsTasks().addAll(Set.of(bobsTask1, bobsTask2));

        Task carolsTask1 = new Task("ProjectB", "Task 5", "Carol", Priority.MED, Status.ASSIGNED_IN);
        Task carolsTask2 = new Task("ProjectC", "Task 6", "Carol", Priority.LOW, Status.IN_PROGRESS);
        taskData.getCarolsTasks().addAll(Set.of(carolsTask1, carolsTask2));

        System.out.println("All tasks: " + taskData.getAllTasks());

        System.out.println("Ann's tasks: " + taskData.getTasks("ann"));
        System.out.println("Bob's tasks: " + taskData.getTasks("bob"));
    }
}