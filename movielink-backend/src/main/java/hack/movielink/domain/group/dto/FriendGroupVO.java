package hack.movielink.domain.group.dto;


import hack.movielink.domain.user.dto.FriendVO;

import java.util.List;

public class FriendGroupVO {

    private Long id;
    private String name;


    public FriendGroupVO(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
