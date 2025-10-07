package com.Ridelink.RideLink.Controller;

import com.Ridelink.RideLink.DTO.UserRegistrationRequest;
import com.Ridelink.RideLink.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/registerAsRider")
    public ResponseEntity<?> regiseterAsRider(@RequestBody UserRegistrationRequest request){
        userService.registerAsRider(request);
        return ResponseEntity.ok().build();
    }

}
