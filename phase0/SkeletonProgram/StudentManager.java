import java.util.HashMap;
import java.util.Set;

public class StudentManager {

    private HashMap<String, Student> students;

    public StudentManager() {
        this.students = new HashMap<String, Student>();
    }

    public StudentManager(HashMap<String, Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.put(student.getUsername(), student);
    }

    public HashMap<String, Student> getAllStudents() {
        return students;
    }

    public void setAllStudents(HashMap<String, Student> students) {
        this.students = students;
    }

    public Set<String> getAllStudentUsers() { return this.students.keySet(); }

    public void addNewStudent(String username, String password){
        students.put(username, new Student(username, password));
    }

    public boolean checkValidStudent(Student student) {
        // returns true if student is already within hashmap, false otherwise
        String user = student.getUsername();
        return this.students.containsKey(user);
    }

}
