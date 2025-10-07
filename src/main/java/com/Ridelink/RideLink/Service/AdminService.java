package com.Ridelink.RideLink.Service;

import com.Ridelink.RideLink.Entity.User;
import com.Ridelink.RideLink.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {

        return userRepository.findAll();
    }
}
