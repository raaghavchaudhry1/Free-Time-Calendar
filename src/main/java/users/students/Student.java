package users.students;

import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
import java.io.Serializable;

import calendar.Calendar;
import backend.Task;
import backend.TaskList;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import users.Person;


public class Student implements Person, Serializable {

    private String username;
    private String password;
    private Calendar schedule;
    private TaskList tasks;


    public Student() {
        this.schedule = new Calendar();
        this.tasks = new TaskList();

    }

    @JsonCreator
    public Student(@JsonProperty("username") String userName, @JsonProperty("password") String password) {
        this.username = userName;
        this.password = password;
        this.schedule = new Calendar();
        this.tasks = new TaskList();

    }

    public Student(String userName, String password, Calendar schedule) {
        this.username = userName;
        this.password = password;
        this.schedule = schedule;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendar getStudentSchedule() {
        return this.schedule;
    }

    public void setStudentSchedule(Calendar schedule) {
        this.schedule = schedule;
    }

    @Override
    public TaskList getTaskList() {
        return this.tasks;
    }

    @Override
    public ArrayList<Task> OpenTasks() {
        ArrayList<Task> openTasks = new ArrayList<>();
        for (Task task: this.tasks.getTasks()) {
            if (!task.isClosed()) {
                openTasks.add(task);
            }
        }
        return openTasks;

    }

    @Override
    public ArrayList<Task> ClosedTasks() {
        ArrayList<Task> closedTasks = new ArrayList<>();
        for (Task task: this.tasks.getTasks()) {
            if (task.isClosed()) {
                closedTasks.add(task);
            }
        }
        return closedTasks;

    }

    @Override
    public int NumTasks() {
        return this.tasks.getTasks().size();
    }

    @Override
    public float totalMinutesCloseTasks() {
        float totalTimeMinutes = (float) 0;
        for (Task task: this.ClosedTasks()) {
            float completionTime = (float) task.getStartDT().until(task.getEndDT(), ChronoUnit.MINUTES);
            totalTimeMinutes += completionTime;
        }
        return totalTimeMinutes;
    }

    @Override
    public float avgTaskCloseTimeDays() {
        float totalTimeMinutes = this.totalMinutesCloseTasks();
        float avgMinutes = totalTimeMinutes / this.NumTasks();
        return avgMinutes / 1440;


    }

    @Override
    public float avgTaskCloseTimeHours() {
        float totalTimeMinutes = this.totalMinutesCloseTasks();
        float avgMinutes = totalTimeMinutes / this.NumTasks();
        return avgMinutes / 60;
    }
}
