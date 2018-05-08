package com.tripforbusiness.controller;

import com.tripforbusiness.helper.ScryptPasswordUtil;
import com.tripforbusiness.helper.UserValidationUtil;
import com.tripforbusiness.model.User;
import com.tripforbusiness.model.UserDetails;
import com.tripforbusiness.repository.UserDetailsRepository;
import com.tripforbusiness.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @ApiOperation(value = "Create new user in the system")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody User user) {
        UserValidationUtil userValidationUtil = new UserValidationUtil();

        if (userValidationUtil.userAlreadyExist(userRepository, user)) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

        ScryptPasswordUtil scryptPasswordUtil = new ScryptPasswordUtil();

        String encryptedPass = scryptPasswordUtil.generateSecurePassword(user.getPassword(), user.getEmail());
        user.setPassword(encryptedPass);

        userRepository.save(user);

        saveUserDetails(user);

        return new ResponseEntity(HttpStatus.OK);
    }

    private void saveUserDetails(@RequestBody User user) {
        UserDetails userDetails = new UserDetails();

        userDetails.setName(user.getName());
        userDetails.setUserId(userRepository.findByEmail(user.getEmail()).get(0).getId());

        userDetailsRepository.save(userDetails);
    }
}
