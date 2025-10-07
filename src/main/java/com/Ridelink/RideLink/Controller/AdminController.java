package com.Ridelink.RideLink.Controller;

import com.Ridelink.RideLink.Entity.User;
import com.Ridelink.RideLink.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers() {
       List<User> allUsers= adminService.getAllUsers();
       return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
