import java.util.HashMap;
import java.util.ArrayList;

class GroupController {

    private GroupManager manager;

    public GroupController(GroupManager manager_var) {
        this.manager = manager_var;


    }


    public boolean AddGroup(Person member, String groupID){

        return (this.manager).addToGroup(member, groupID);

    }

    public boolean removeMember(Person member, String groupID){

        return (this.manager).removeGroupMember(member, groupID);

    }
















}

