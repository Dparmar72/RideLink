package com.Ridelink.RideLink.Controller;

import com.Ridelink.RideLink.DTO.UserRegistrationRequest;
import com.Ridelink.RideLink.Entity.User;
import com.Ridelink.RideLink.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rideLink/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<?> register(@RequestBody UserRegistrationRequest request) {
        try {
            userService.registerUser(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().build();
    }
}
