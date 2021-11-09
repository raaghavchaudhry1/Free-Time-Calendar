import java.util.HashMap;
import java.util.Set;

public class StudentController {

    private StudentManager studentManager;

    public boolean addStudent(Student student) {
        // returns true if student has been added to hashmap, false if student already exists
        if (studentManager.checkValidStudent(student)) {
            return false;
        } else {
            studentManager.addStudent(student);
            return true;
        }
    }
}
