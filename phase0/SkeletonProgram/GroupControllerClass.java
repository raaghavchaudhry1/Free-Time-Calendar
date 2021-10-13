import java.util.HashMap;
import java.util.ArrayList;

class GroupController {

    private GroupManager manager;

    public GroupController(GroupManager manager_var) {
        this.manager = manager_var;


    }


    public boolean AddGroup(Student member, String groupID){

        return (this.manager).addToGroup(member, groupID);

    }

    public boolean removeMember(Student member, String groupID){

        return (this.manager).removeGroupMember(member, groupID);

    }
















}

