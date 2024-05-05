package com.lcwd.auth.service.repository;

import com.lcwd.auth.service.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials,Integer>
{
    Optional<UserCredentials> findByUserName(String username);
}
