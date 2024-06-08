package hack.movielink.domain.group.repository;

import hack.movielink.domain.group.entity.FriendGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupJpaRepository extends JpaRepository<FriendGroup, Long> {
    List<FriendGroup> findByMembersEmail(String email);

}
