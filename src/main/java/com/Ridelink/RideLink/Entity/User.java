package com.Ridelink.RideLink.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String mobileNo;

    @Column(nullable = false, unique = true)
    private String email;

    private String role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)

    private Rider rider;


}
