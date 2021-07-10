package com.dkinc.leaderBoards.repositories;

import com.dkinc.leaderBoards.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepos extends JpaRepository<User, Long> {
    List<User> findByNickname(String nickname);
    List<User> findByEmail(String email);
    List<User>findByLevel(Integer level);

}
