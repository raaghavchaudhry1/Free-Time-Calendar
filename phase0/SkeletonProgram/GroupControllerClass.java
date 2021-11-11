import java.util.HashMap;
import java.util.ArrayList;

class GroupController {

    private GroupManager manager;

    public GroupController() {
        this.manager =  new GroupManager();


    }


    public boolean addToGroup(Student member, String groupID){

        return (this.manager).addToGroup(member, groupID);

    }

    public boolean removeMember(Student member, String groupID){

        return (this.manager).removeGroupMember(member, groupID);

    }




















}

