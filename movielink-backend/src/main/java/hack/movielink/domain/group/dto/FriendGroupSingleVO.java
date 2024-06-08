package hack.movielink.domain.group.dto;


import hack.movielink.domain.group.entity.Post;
import hack.movielink.domain.user.dto.FriendVO;

import java.util.List;

public class FriendGroupSingleVO {

    private Long id;
    private String name;
    private List<String> members;
    private List<Post> posts;


    public FriendGroupSingleVO(Long id, String name, List<String> members, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.posts = posts;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
