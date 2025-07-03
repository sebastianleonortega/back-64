package com.base64.gamesback.auth.user.repository;

import com.base64.gamesback.auth.user.dto.projection.UserProjection;
import com.base64.gamesback.auth.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository  extends JpaRepository<User, UUID> {

    User getUserByName(String userName);

    Boolean existsUserByName(String userName);

    @Query(value = "SELECT u.name AS name, u.administrator AS administrator, u.profile_image AS profileImage, " +
            "p.first_name AS firstName, p.last_name AS LastName, p.document_number AS documentNumber, p.address AS address, p.phone AS phone, " +
            "p.email AS email FROM main.user u INNER JOIN main.person p ON u.user_id = p.user_id WHERE u.user_id = :userId", nativeQuery = true)
    UserProjection getUserId(@Param("userId") UUID userId);

    @Modifying
    @Query("UPDATE User u SET u.password = :password WHERE u.userId = :userId")
    void updatePasswordById(@Param("userId")  UUID userId, String password);

}
