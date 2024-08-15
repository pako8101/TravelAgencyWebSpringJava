package com.kamenov.travelagencywebspringjava.repository;

import com.kamenov.travelagencywebspringjava.model.entities.UserEntity;
import com.kamenov.travelagencywebspringjava.service.ApplicationUserDetailsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserEntByUsername(String username);

    Optional<UserEntity> findByEmail(String value);
}
