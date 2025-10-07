package com.Ridelink.RideLink.Service;

import com.Ridelink.RideLink.DTO.UserRegistrationRequest;
import com.Ridelink.RideLink.Entity.Rider;
import com.Ridelink.RideLink.Entity.User;
import com.Ridelink.RideLink.Repository.RiderRepository;
import com.Ridelink.RideLink.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RiderRepository riderRepository;


    public void registerUser(UserRegistrationRequest request) {

        if(userRepository.existsByEmail(request.getEmail())){
           throw new RuntimeException("Email already registered");
        }

       try{
           User user = new User();
           user.setUserName(request.getUserName());
           user.setMobileNo(request.getMobileNo());
           user.setEmail(request.getEmail());

           String role = (request.getRole() == null || request.getRole().isBlank()) ? "PASSANGER" : request.getRole();
           user.setRole(role);

           User savedUser = userRepository.save(user);

           if("RIDER".equalsIgnoreCase(role)){
               Rider rider = new Rider();
               rider.setLicenseNumber(request.getLicenseNumber());
               rider.setRcNumber(request.getRcNumber());
               rider.setAadharNumber(request.getAadharNumber());
               rider.setUser(savedUser);

               riderRepository.save(rider);
           }
       }
       catch (Exception e){
           throw new RuntimeException(e);
       }

    }

    public void registerAsRider(UserRegistrationRequest request) {

        if(riderRepository.existsByAadharNumber(request.getAadharNumber())){
            throw new RuntimeException("Rider already registered with this aadhar number");
        }

        try {
            Rider rider = new Rider();
            rider.setLicenseNumber(request.getLicenseNumber());
            rider.setRcNumber(request.getRcNumber());
            rider.setAadharNumber(request.getAadharNumber());
            rider.setUser(userRepository.findByUserId(request.getUserId()));

            riderRepository.save(rider);
        }
        catch (Exception e){
            throw new RuntimeException("Please Enter Correct Details");
        }

    }
}
