import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskList implements Serializable {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
    }

    public void closeTask(Task task) {
        task.editEndDT(LocalDateTime.now());
    }

    public int getNumTasks() {
        return this.tasks.size();
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }
}
