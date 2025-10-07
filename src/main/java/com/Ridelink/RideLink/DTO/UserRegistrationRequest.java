package com.Ridelink.RideLink.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserRegistrationRequest {

    private long userId;
    private String userName;
    private String mobileNo;
    private String email;
    private String role;


    private String licenseNumber;
    private String rcNumber;
    private String aadharNumber;

}
