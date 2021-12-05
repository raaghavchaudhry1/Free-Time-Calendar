package login;

import users.students.StudentBuilder;
import users.students.StudentController;

import java.util.HashMap;

public class LogIn {

    private HashMap<String, StudentBuilder> userMap;

    public LogIn(StudentController students) {

        this.userMap = students.getAllStudents();

    }

    public boolean checkUsername(String userName) {

        boolean usernameInUsermap;

        usernameInUsermap = userMap.containsKey(userName);
        return usernameInUsermap;
    }

    public boolean validateLogIn(String userName, String password) {
        boolean validUsername = this.checkUsername(userName);
        boolean validPassword = false;
        if (validUsername) {
            validPassword = this.userMap.get(userName).getPassword().equals(password);
        }
        return validPassword;
    }

}
