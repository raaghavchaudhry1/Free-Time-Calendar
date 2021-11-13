import java.util.ArrayList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

public class GsonRead {
    public static void main(String[] Args) {
        StudentManager studm = new StudentManager();
        CalendarManager calm = new CalendarManager();

        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson gson = builder.create();

        String fileName = "src/main/java/studs.json";


        try (Reader reader = new FileReader(fileName)) {
            Student[] students = gson.fromJson(reader, Student[].class);
            System.out.println(students[0].getUsername());
            students[0].setUsername("Horus");
            System.out.println(students[0].getUsername());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
