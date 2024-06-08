package hack.movielink.domain.user.dto;

// we use this to return friend information, not the whole user
// no need to expose all friend information to the frontend
public class FriendVO {

    private String email;
    private String fullName;
    private String profilePicture;

    public FriendVO(String email, String fullName, String profilePicture) {
        this.email = email;
        this.fullName = fullName;
        this.profilePicture = profilePicture;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "FriendVO{" +
                "email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
