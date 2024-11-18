package com.example.scheduledevelop.repository;

import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findScheduleByUsername(String username);

    default User findScheduleByUsernameOrElseThrow(String username) {
        return findScheduleByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doest net exist username = "+ username));
    }
}
