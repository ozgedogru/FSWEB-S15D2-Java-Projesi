package model;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;

    public TaskData() {
        this.annsTasks = new HashSet<>();
        this.bobsTasks = new HashSet<>();
        this.carolsTasks = new HashSet<>();
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    // Method to get tasks based on employee name or "all"
    public Set<Task> getTasks(String employee) {
        Set<Task> tasks = new HashSet<>();
        switch (employee.toLowerCase()) {
            case "ann":
                tasks.addAll(annsTasks);
                break;
            case "bob":
                tasks.addAll(bobsTasks);
                break;
            case "carol":
                tasks.addAll(carolsTasks);
                break;
            case "all":
                tasks.addAll(getUnion(annsTasks, bobsTasks, carolsTasks));
                break;
            default:
                throw new IllegalArgumentException("Invalid employee name: " + employee);
        }
        return tasks;
    }

    // Method to find the union of multiple sets
    private Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> set : sets) {
            union.addAll(set);
        }
        return union;
    }

    // Method to find the intersection of two sets
    private Set<Task> getIntersect(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);
        return intersect;
    }

    // Method to find the difference between two sets
    private Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {
        Set<Task> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }

    // Method to get all tasks across all employees
    public Set<Task> getAllTasks() {
        return getUnion(annsTasks, bobsTasks, carolsTasks);
    }

    // Method to get tasks assigned to a specific employee
    public Set<Task> getTasksByAssignee(String assignee) {
        Set<Task> allTasks = getAllTasks();
        Set<Task> tasksByAssignee = new HashSet<>();

        for (Task task : allTasks) {
            if (task.getAssignee().equalsIgnoreCase(assignee)) {
                tasksByAssignee.add(task);
            }
        }

        return tasksByAssignee;
    }

    // Method to get unassigned tasks
    public Set<Task> getUnassignedTasks() {
        Set<Task> allTasks = getAllTasks();
        Set<Task> unassignedTasks = new HashSet<>();

        for (Task task : allTasks) {
            if (task.getAssignee().isEmpty()) {
                unassignedTasks.add(task);
            }
        }

        return unassignedTasks;
    }

    // Method to check if there are tasks assigned to multiple employees
    public boolean hasTasksAssignedToMultipleEmployees() {
        Set<Task> allTasks = getAllTasks();
        Set<Task> intersection = new HashSet<>();
        Set<Task> union = new HashSet<>();

        for (Task task : allTasks) {
            if (!union.add(task)) {
                intersection.add(task);
            }
        }

        return !intersection.isEmpty();
    }

    // Method to get tasks assigned to multiple employees
    public Set<Task> getTasksAssignedToMultipleEmployees() {
        Set<Task> allTasks = getAllTasks();
        Set<Task> intersection = new HashSet<>();
        Set<Task> union = new HashSet<>();

        for (Task task : allTasks) {
            if (!union.add(task)) {
                intersection.add(task);
            }
        }

        return intersection;
    }
}