import java.util.HashMap;
import java.util.ArrayList;

public class GroupManager {

    private HashMap<String, Group> groupMap;

    public GroupManager() {

        this.groupMap = new HashMap<String, Group>();

    }


    public Group CreateGroup(ArrayList<Student> groupMembers, String groupName) {

        Group newGroup = new Group(groupName);
        newGroup.setStudentsInGroup(groupMembers);
        Integer groupSize = ((this.groupMap).size());
        newGroup.setgID(groupSize.toString());
        (this.groupMap).put((newGroup.getgID()).toString(), newGroup);

        return newGroup;
    }

    public boolean addToGroup(Student student, String GroupID) {

        if ((this.groupMap).containsKey(GroupID)) {

            ArrayList<Student> students=  ((this.groupMap).get(GroupID)).getStudentsInGroup();
            students = new ArrayList<Student>(students);
            students.add(student);
            ((this.groupMap).get(GroupID)).setStudentsInGroup(students);



            return true;


        } else {

            return false;
        }


    }

    public boolean removeGroupMember(Student student, String GroupID) {

        if ((this.groupMap).containsKey(GroupID)) {

            ArrayList<Student> students=  ((this.groupMap).get(GroupID)).getStudentsInGroup();
            students = new ArrayList<Student>(students);
            students.remove(student);
            ((this.groupMap).get(GroupID)).setStudentsInGroup(students);



            return true;


        } else {

            return false;
        }

    }

    public Group getGroup(String gID) { return this.groupMap.get(gID); }

}


