import java.util.ArrayList;

public class Group {

    private ArrayList<Student> students;
    private String name;
    private String gID;

    public Group(String name) {
        this.students = new ArrayList<Student>();
        this.name = name;
        this.gID = null;
    }

    public ArrayList<Student> getStudentsInGroup() {
        return students;
    }

    public void setStudentsInGroup(ArrayList<Student> students) {
        this.students = students;
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

        for (Student student : this.students) { calendars.add(student.getStudentSchedule()); }
        return calendars;
    }

}