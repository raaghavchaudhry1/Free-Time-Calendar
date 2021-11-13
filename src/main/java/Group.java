import java.lang.reflect.Array;
import java.util.ArrayList;

public class Group implements Person {

    private ArrayList<Person> members;
    private String name;
    private String gID;

    public Group(String name) {
        this.members = new ArrayList<Person>();
        this.name = name;
        this.gID = null;
    }

    public ArrayList<Person> getMembers() {
        return this.members;
    }

    public ArrayList<Person> getStudentsInGroup() {
        ArrayList<Person> students = new ArrayList<>();
        for (Person member: this.members) {
            if (member instanceof Student) {
                students.add(member);
            } else {
                students.addAll(((Group) member).getStudentsInGroup());
            }
        }

        return students;
    }

    public void setStudentsInGroup(ArrayList<Person> students) {
        this.members = students;
    }

    public String getGroupName() {
        return name;
    }

    public void setGroupName(String name) {
        this.name = name;
    }

    public String getgID() {
        return gID;
    }

    public void setgID(String gID) {
        this.gID = gID;
    }

    public ArrayList<Calendar> getCalendars() {

        ArrayList<Calendar> calendars = new ArrayList<Calendar>();
        ArrayList<Person> students = this.getStudentsInGroup();

        for (Person student : students) {
            Calendar stuCal = ((Student) student).getStudentSchedule();
            calendars.add(stuCal);
        }
        return calendars;
    }

    @Override
    public TaskList getTaskList() {
        TaskList studentTasks = new TaskList();
        ArrayList<Task> listOfTasks = new ArrayList<>();
        for (Person member: this.members) {
            listOfTasks.addAll(member.getTaskList().getTasks());

        }
        for (Task task: listOfTasks) {
            studentTasks.addTask(task);
        }
        return studentTasks;
    }

    @Override
    public ArrayList<Task> getOpenTasks() {
        ArrayList<Task> openTasks = new ArrayList<>();
        for (Person member: this.members) {
            openTasks.addAll(member.getOpenTasks());

        }
        return openTasks;

    }

    @Override
    public ArrayList<Task> getClosedTasks() {
        ArrayList<Task> closedTasks = new ArrayList<>();
        for (Person member: this.members) {
            closedTasks.addAll(member.getClosedTasks());
        }
        return closedTasks;
    }

    @Override
    public int getNumTasks() {
        int totalTasks = 0;
        for (Person member: this.members) {
            totalTasks += member.getNumTasks();
        }
        return totalTasks;
    }

    @Override
    public float totalMinutesCloseTasks() {
        float totalMinutes = (float) 0;
        for (Person member: this.members) {
            totalMinutes += member.totalMinutesCloseTasks();
        }
        return totalMinutes;
    }

    @Override
    public float avgTaskCloseTimeDays() {
        float totalMinutes = this.totalMinutesCloseTasks();
        int totalTasks = this.getNumTasks();
        float avgMinutes = totalMinutes / totalTasks;
        return avgMinutes / 1440;

    }

    @Override
    public float avgTaskCloseTimeHours() {
        float totalMinutes = this.totalMinutesCloseTasks();
        int totalTasks = this.getNumTasks();
        float avgMinutes = totalMinutes / totalTasks;
        return avgMinutes / 60;

    }

}