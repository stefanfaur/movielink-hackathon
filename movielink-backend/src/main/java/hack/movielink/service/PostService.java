package hack.movielink.service;

import hack.movielink.domain.group.entity.FriendGroup;
import hack.movielink.domain.group.entity.Post;
import hack.movielink.domain.group.repository.GroupJpaRepository;
import hack.movielink.domain.group.repository.PostJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostJpaRepository postJpaRepository;
    private final GroupJpaRepository groupJpaRepository;

    public PostService(PostJpaRepository postJpaRepository, GroupJpaRepository groupJpaRepository) {
        this.postJpaRepository = postJpaRepository;
        this.groupJpaRepository = groupJpaRepository;
    }

    public void createPost(String title, String content, String location, int rating, Long groupId) {

        FriendGroup group = groupJpaRepository.findById(groupId).orElseThrow();

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setLocation(location);
        post.setRating(rating);
        post.setCoverImage("https://picsum.photos/200/300");
        post.setFriendGroup(group);
        postJpaRepository.save(post);
    }

    public List<Post> getPostsForGroup(Long id) {
        List<Post> posts = postJpaRepository.findAllByFriendGroup_Id(id);
        System.out.println("posts: " + posts);
        return posts;
    }
}
