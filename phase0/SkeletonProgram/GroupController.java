import java.util.HashMap;
import java.util.ArrayList;

public class GroupController {

    private GroupManager manager;

    public GroupController() {
        this.manager =  new GroupManager();


    }

//    should it be void??

    public void createGroup(ArrayList<Student> groupMembers, String groupName){
         (this.manager).CreateGroup(groupMembers, groupName);
    }


    public boolean addToGroup(Student member, String groupID){

        return (this.manager).addToGroup(member, groupID);

    }

    public boolean removeMember(Student member, String groupID){

        return (this.manager).removeGroupMember(member, groupID);

    }




















}

