package hack.movielink.domain.group.repository;

import hack.movielink.domain.group.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByFriendGroup_Id(Long id);

}
