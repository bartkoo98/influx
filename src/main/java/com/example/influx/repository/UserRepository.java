package com.example.influx.repository;

import com.example.influx.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface UserRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByEmail(String email);
    Boolean existsByEmail(String email);
    List<UserAccount> findAllUsersByRoles_Name(String role);
    void deleteById(Long id);
}
