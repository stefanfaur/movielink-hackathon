package hack.movielink.service;

import hack.movielink.domain.group.dto.FriendGroupVO;
import hack.movielink.domain.group.entity.FriendGroup;
import hack.movielink.domain.group.repository.GroupJpaRepository;
import hack.movielink.domain.user.dto.FriendVO;
import hack.movielink.domain.user.entity.User;
import hack.movielink.domain.user.repository.UserJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GroupService {

    private final GroupJpaRepository groupRepository;
    private final UserJpaRepository userRepository;

    public GroupService(GroupJpaRepository groupRepository, UserJpaRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void createGroup(List<String> userEmails, String groupName) {
        FriendGroup group = new FriendGroup();
        group.setName(groupName);
        List<User> members = userRepository.findByEmailIn(userEmails);
        group.setMembers(members);
        groupRepository.save(group);
    }


    // I know sending all user info isn't cool but it's a hackathon an I'm outta time
    @Transactional
    public List<FriendGroup> getUserGroups(String email) {
        try {
            List<FriendGroup> groups = groupRepository.findByMembersEmail(email);

            // Check if groups are fetched correctly
            System.out.println("Fetched Groups: " + groups.size());

            return groups;

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    public FriendGroup getGroup(Long id) {
        return groupRepository.findById(id).orElseThrow();
    }
}
