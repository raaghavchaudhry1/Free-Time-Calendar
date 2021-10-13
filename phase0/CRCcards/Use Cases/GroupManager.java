import java.util.HashMap;
import java.util.ArrayList;

class GroupManager {

    private Hashmap<String, Group> groupMap;

    public GroupManager() {

        this.groupMap = new HashMap<String, Group>();

    }

    public Group CreateGroup(ArrayList<Student> groupMembers, String groupName) {

        Group newGroup = new Group(groupMembers, groupName);
        newGroup.setgID(((this.groupMap).size()).toString());
        (this.groupMap).put((newGroup.getgID).toString(), newGroup);

        return newGroup;
    }

    public boolean addToGroup(Student student, String GroupId) {

        if ((this.groupMap).containsKey(GroupId)) {

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

        if ((this.groupMap).containsKey(GroupId)) {

            ArrayList<Student> students=  ((this.groupMap).get(GroupID)).getStudentsInGroup();
            students = new ArrayList<Student>(students);
            students.remove(student);
            ((this.groupMap).get(GroupID)).setStudentsInGroup(students);



            return true;


        } else {

            return false;
        }

    }























}


