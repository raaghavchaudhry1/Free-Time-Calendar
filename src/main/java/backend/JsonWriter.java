package backend;

import java.util.*;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import users.*;
import users.groups.Group;
import users.groups.GroupController;
import users.students.StudentBuilder;
import users.students.StudentController;

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
        StudentBuilder[] studentBuilderArray = new StudentBuilder[totalStudents];

        ArrayList<StudentBuilder> studentBuilders = new ArrayList<>(stuMan.getAllStudents().values());
        for (int i = 0; i < totalStudents; i++) {
            studentBuilderArray[i] = studentBuilders.get(i);
        }


        GsonBuilder gbuild = new GsonBuilder();
        gbuild.serializeNulls();
        Gson gson = gbuild.setPrettyPrinting().create();

        FileWriter studentJson = new FileWriter(filePath);
        gson.toJson(studentBuilderArray, studentJson);
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
        mapper.registerSubtypes(new NamedType(StudentBuilder.class, "Student"));
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
                    if (student instanceof StudentBuilder) {
                        students.add(((StudentBuilder) student).getUsername());
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
