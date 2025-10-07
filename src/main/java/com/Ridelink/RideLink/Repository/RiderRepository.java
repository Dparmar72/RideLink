package com.Ridelink.RideLink.Repository;

import com.Ridelink.RideLink.Entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Long> {
    boolean existsByAadharNumber(String aadharNumber);

}
