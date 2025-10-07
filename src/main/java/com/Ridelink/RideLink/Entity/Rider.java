package com.Ridelink.RideLink.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rider")
@Data
public class Rider {

    @Id
    private Long riderId;

    private String licenseNumber;
    private String rcNumber;
    private String aadharNumber;

    @OneToOne
    @MapsId
    @JoinColumn(name = "rider_id")
    @JsonBackReference
    private User user;


}
