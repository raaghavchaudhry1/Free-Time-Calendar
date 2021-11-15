package backend;

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
    private String studentJsonLoc;
    private String groupJsonLoc;

    public JsonWriter() {
        this.studentJsonLoc = "src/main/java/students.json";
        this.groupJsonLoc = "src/main/java/groups.json";
    }

    public void studentJsonWriter(StudentController stuMan) throws IOException {

        String filePath = this.studentJsonLoc;

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

    public void groupJsonWriter(GroupController grpMan) throws IOException {

        String grpfilePath = this.groupJsonLoc;

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

    public void groupJsonWriterSimplified(GroupController grpMan) throws IOException {

        String grpfilePath = this.groupJsonLoc;

        int totalGroups = grpMan.getGroups().size();
//        HashMap[] groupArray = new HashMap[totalGroups];
        HashMap<String, ArrayList<String>> groupHash = new HashMap<>();

        ArrayList<Group> groups = new ArrayList<>(grpMan.getGroups().values());
        for (int i = 0; i < totalGroups; i++) {
            if (groups.get(i) instanceof Group) {
                ArrayList<String> students = new ArrayList<>();
                for (Person student: groups.get(i).getMembers()) {
                    if (student instanceof Student) {
                        students.add(((Student) student).getUsername());
                    }
                }
                groupHash.put(groups.get(i).getGroupName(), students);
            }
        }

        GsonBuilder gbuild = new GsonBuilder();
        gbuild.serializeNulls();
        Gson gson = gbuild.setPrettyPrinting().create();

        FileWriter studentJson = new FileWriter(grpfilePath);
        gson.toJson(groupHash, studentJson);
        studentJson.close();

    }
}
