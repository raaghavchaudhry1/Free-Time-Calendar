import java.util.HashMap;
import java.util.ArrayList;

class GroupManager {

    private Hashmap<String, Group> groupMap;

    public GroupManager() {

        this.groupMap = new HashMap<String, Group>();

    }

    public Group CreateGroup(ArrayList<Student> groupMembers, String groupName) {

        Group newGroup = new Group(groupMembers, groupName);
        newGroup.setId(((this.groupMap).size()).toString());
        (this.groupMap).put((newGroup.getID).toString(), newGroup);

        return newGroup;
    }

    public boolean addToGroup(Student student, String GroupId) {

        if ((this.groupMap).containsKey(GroupId)) {

            (groupMap.get(GroupId)).addMember(student);
            return true;


        } else {

            return false;
        }


    }

    public boolean removeGroupMember(Student student, String GroupID) {

        if ((this.groupMap).containsKey(GroupID)) {

            (groupMap.get(GroupID)).RemoveMember(student);
            return true;


        } else {
            return false;
        }


    }























}


