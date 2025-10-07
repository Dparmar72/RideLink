package com.Ridelink.RideLink.Repository;

import com.Ridelink.RideLink.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    User findByUserId(long userId);
}
