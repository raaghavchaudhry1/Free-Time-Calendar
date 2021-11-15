import java.io.*;
import java.util.*;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Scanner;

public class JsonReader {
    private String studentJsonLoc;
    private String groupJsonLoc;

    public JsonReader() {
        this.studentJsonLoc = "src/main/java/students.json";
        this.groupJsonLoc = "src/main/java/groups.json";
    }

    public Student[] readStudentJson() throws FileNotFoundException {

        String filePath = this.studentJsonLoc;

        GsonBuilder gbuild = new GsonBuilder();
        gbuild.serializeNulls();
        Gson gson = gbuild.setPrettyPrinting().create();

        Reader reader = new FileReader(filePath);
        Student[] studentArray = gson.fromJson(reader, Student[].class);
        return studentArray;

    }

    public Group[] readGroupJson() throws IOException {

        String grpfilePath = this.groupJsonLoc;

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerSubtypes(new NamedType(Student.class, "Student"));
        mapper.registerSubtypes(new NamedType(Group.class, "Group"));
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Reader grpreader = new FileReader(grpfilePath);

        List<Group> groups = Arrays.asList(mapper.readValue(grpreader, Group[].class));
        grpreader.close();
        Group[] groupArray = new Group[groups.size()];
        for (int i = 0; i < groups.size(); i++) {
            groupArray[i] = groups.get(i);
        }
        return groupArray;

    }

    public boolean savedInfoStudents() {
        String filePath = "src/main/java/students.json";
        File studentJson = new File(filePath);
        return studentJson.exists();

    }

    public boolean savedInfoGroups() {

        String grpfilePath = "src/main/java/groups.json";

        File groupJson = new File(grpfilePath);
        return groupJson.exists();

    }
}
