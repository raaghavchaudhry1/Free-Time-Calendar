import java.util.HashMap;
import java.util.ArrayList;

class GroupManager {

    private HashMap<String, Group> groupMap;

    public GroupManager() {

        this.groupMap = new HashMap<String, Group>();

    }

    public Group CreateGroup(ArrayList<Person> groupMembers, String groupName) {

        Group newGroup = new Group(groupName);
        newGroup.setStudentsInGroup(groupMembers);
        Integer groupSize = ((this.groupMap).size());
        newGroup.setgID(groupSize.toString());
        (this.groupMap).put((newGroup.getgID()).toString(), newGroup);

        return newGroup;
    }

    public boolean addToGroup(Person student, String GroupID) {

        if ((this.groupMap).containsKey(GroupID)) {

            this.groupMap.get(GroupID).getMembers().add(student);

            return true;


        } else {

            return false;
        }


    }

    public boolean removeGroupMember(Person student, String GroupID) {

        if ((this.groupMap).containsKey(GroupID)) {

            if (this.groupMap.get(GroupID).getMembers().contains(student)) {
                this.groupMap.get(GroupID).getMembers().remove(student);
                return true;
            }
            return false;

        } else {

            return false;
        }

    }

    public Group getGroup(String gID) { return this.groupMap.get(gID); }

    public HashMap<String, Group> getGroups() {
        return this.groupMap;
    }

    public void addTask(String gID, Task task) {
        this.groupMap.get(gID).getTaskList().addTask(task);

    }

    public void removeTask(String gID, Task task) {
        this.groupMap.get(gID).getTaskList().removeTask(task);
    }

    public void closeTask(String gID, Task task) {
        this.groupMap.get(gID).getTaskList().closeTask(task);
    }

}


