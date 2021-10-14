public class Student {

    private String username;
    private String password;
    private Calendar schedule;

    public Student(String userName, String password) {
        this.username = userName;
        this.password = password;
        this.schedule = new Calendar;
    }

    public Student(String userName, String password, Calendar schedule) {
        this.username = userName;
        this.password = password;
        this.schedule = schedule;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendar getStudentSchedule() {
        return schedule;
    }

    public void setStudentSchedule(Calendar schedule) {
        this.schedule = schedule;
    }
}
