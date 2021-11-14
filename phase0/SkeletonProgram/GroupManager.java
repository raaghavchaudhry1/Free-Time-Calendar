import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class GroupManager {

    private HashMap<String, Group> groupMap;

    public GroupManager() {

        this.groupMap = new HashMap<String, Group>();

    }

    public ArrayList<String> getStudentUsername( String gID) {

        Group curr = this.groupMap.get(gID);
        return curr.getStudentsUsername();



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

    public String getID(Group group) {

        return group.getgID();
    }


    public ArrayList<ArrayList<Object>> getStudentGroups(Student currStudent) {
        ArrayList<ArrayList<Object>> groups = new ArrayList<>();

        for (Group group: this.groupMap.values()){
            ArrayList<Object> newList = new ArrayList<Object>();




            if (group.checkStudent(currStudent)) {
                newList.add(group);
                newList.add(group.getGroupName());
                newList.add(group.getgID());
            }

            groups.add(newList);


        }
        return groups;




    }







}


