package com.example.ControlWork;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT userId AS user_id,userName as user_name, positionOnStarship as position_on_starship, age,sex,balance,background, publicBackground as public_background, photo, securityBackground as security_background, medicalBackground as medical_background, psychologyBackground as psychology_background,lastAvailable as last_available,  userSettings as user_settings FROM users", nativeQuery = true)
    List<User> findAllUsers();
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (userId, userName, positionOnStarship, age, sex, balance, background, publicBackground, photo, securityBackground, medicalBackground, psychologyBackground, lastAvailable, userSettings) VALUES (:#{#user.id}, :#{#user.userName}, :#{#user.positionOnStarship}, :#{#user.age}, :#{#user.sex}, :#{#user.balance}, :#{#user.background}, :#{#user.publicBackground}, :#{#user.photo}, :#{#user.securityBackground}, :#{#user.medicalBackground}, :#{#user.psychologyBackground}, :#{#user.lastAvailable}, :#{#user.userSettings})", nativeQuery = true)
    void addUser(@RequestBody User user);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE  userId = :userId", nativeQuery = true)
    void deleteUserById(@Param("userId") Long userId);
}
