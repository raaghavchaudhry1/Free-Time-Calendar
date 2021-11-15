import java.sql.Array;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.util.Scanner;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonWriter {

    public void studentJsonWriter(StudentManager stuMan) throws IOException {

        String filePath = "src/main/java/students.json";

        int totalStudents = stuMan.getAllStudents().size();
        Student[] studentArray = new Student[totalStudents];

        ArrayList<Student> students = new ArrayList<>(stuMan.getAllStudents().values());
        for (int i = 0; i < totalStudents; i++) {
            studentArray[i] = students.get(i);
        }


        GsonBuilder gbuild = new GsonBuilder();
        gbuild.serializeNulls();
        Gson gson = gbuild.setPrettyPrinting().create();

        FileWriter studentJson = new FileWriter(filePath);
        gson.toJson(studentArray, studentJson);
        studentJson.close();

    }

    public void groupJsonWriter(GroupManager grpMan) throws IOException {

        String grpfilePath = "src/main/java/groups.json";

        int totalGroups = grpMan.getGroups().size();
        Group[] groupArray = new Group[totalGroups];

        ArrayList<Group> groups = new ArrayList<>(grpMan.getGroups().values());
        for (int i = 0; i < totalGroups; i++) {
            groupArray[i] = groups.get(i);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerSubtypes(new NamedType(Student.class, "Student"));
        mapper.registerSubtypes(new NamedType(Group.class, "Group"));
        mapper.findAndRegisterModules();

        ObjectWriter mapwriter = mapper.writer(new DefaultPrettyPrinter());

        FileWriter groupJson = new FileWriter(grpfilePath);
        mapwriter.writeValue(groupJson, groupArray);

    }
}