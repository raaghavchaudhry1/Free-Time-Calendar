import java.util.ArrayList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.util.Scanner;

public class main {

    public static void main(String[] Args) throws IOException {
        StudentManager studm = new StudentManager();
        CalendarManager calm = new CalendarManager();
        Student stud1 = new Student("Vergil", "pass");
        Student stud2 = new Student("Taj", "god");
        Student stud3 = new Student("Cath", "sloth");
        Student stud4 = new Student("Rag", "god");
        Student stud5 = new Student("Gil", "thunder");

        CalendarEvent cal1 = new CalendarEvent("guitar lesson", 1320, 1530, "Monday");
        CalendarEvent cal2 = new CalendarEvent("piano lesson", 1120, 1230, "Monday");
        CalendarEvent cal3 = new CalendarEvent("violin lesson", 1320, 1530, "Tuesday");
        CalendarEvent cal4 = new CalendarEvent("bass lesson", 1620, 1830, "Tuesday");
        CalendarEvent cal5 = new CalendarEvent("oboe lesson", 1320, 1530, "Friday");
        CalendarEvent cal6 = new CalendarEvent("math lesson", 839, 1040, "Friday");
        CalendarEvent cal7 = new CalendarEvent("art lesson", 1200, 1230, "Friday");
        CalendarEvent cal8 = new CalendarEvent("chinese lesson", 1320, 1530, "Monday");
        CalendarEvent cal9 = new CalendarEvent("french lesson", 1320, 1530, "Monday");
        CalendarEvent cal10 = new CalendarEvent("italian lesson", 1320, 1530, "Tuesday");
        CalendarEvent cal11 = new CalendarEvent("history lesson", 1320, 1530, "Tuesday");
        CalendarEvent cal12 = new CalendarEvent("physics lesson", 1320, 1530, "Wednesday");

        stud1.getStudentSchedule().addRecurEvent("Monday", cal1);
        stud1.getStudentSchedule().addRecurEvent("Monday", cal2);
        stud1.getStudentSchedule().addRecurEvent("Tuesday", cal3);
        stud1.getStudentSchedule().addRecurEvent("Tuesday", cal4);
        stud1.getStudentSchedule().addRecurEvent("Friday", cal5);
        stud1.getStudentSchedule().addRecurEvent("Friday", cal6);
        stud1.getStudentSchedule().addRecurEvent("Friday", cal7);
        stud2.getStudentSchedule().addRecurEvent("Monday", cal8);
        stud2.getStudentSchedule().addRecurEvent("Tuesday", cal9);
        stud2.getStudentSchedule().addRecurEvent("Tuesday", cal10);

        Student[] studarray = {stud1, stud2, stud3, stud4, stud5};

        String fileName = "src/main/java/studs.json";


        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson gson = builder.create();

        System.out.println(gson.toJson(studarray));
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(studarray, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
