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

    public ArrayList<String> getStudentsUsername() {

        ArrayList<String> list = new ArrayList<>();

        for (Student student: this.students) {
            list.add(student.getUsername());

        }

        return list;

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

    public Boolean checkStudent(Student student) {

        if (this.students.contains(student)) {
            return true;
        } else {
            return false;
        }

    }

}