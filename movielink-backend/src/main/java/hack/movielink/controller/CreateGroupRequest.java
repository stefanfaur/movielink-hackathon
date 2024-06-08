package hack.movielink.controller;

import java.util.List;

public class CreateGroupRequest {

    private String groupName;
    private List<String> userEmails;

    public CreateGroupRequest(String groupName, List<String> userEmails) {
        this.groupName = groupName;
        this.userEmails = userEmails;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<String> getUserEmails() {
        return userEmails;
    }

    public void setUserEmails(List<String> userEmails) {
        this.userEmails = userEmails;
    }
}
