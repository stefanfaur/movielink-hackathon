package hack.movielink.controller;

public class AddPostRequest {

    private String title;
    private String content;
    private String location;
    private int rating;
    private Long groupId;

    public AddPostRequest(String title, String content, String location, int rating, Long groupId) {
        this.title = title;
        this.content = content;
        this.location = location;
        this.rating = rating;
        this.groupId = groupId;
    }

    public AddPostRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
