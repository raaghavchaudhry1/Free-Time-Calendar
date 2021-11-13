import java.util.ArrayList;

public interface Person {
    TaskList getTaskList();
    ArrayList<Task> getOpenTasks();
    ArrayList<Task> getClosedTasks();
    int getNumTasks();
    float totalMinutesCloseTasks();
    float avgTaskCloseTimeDays();
    float avgTaskCloseTimeHours();
}