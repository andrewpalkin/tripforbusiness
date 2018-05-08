package com.tripforbusiness.controller;

import com.tripforbusiness.helper.ScryptPasswordUtil;
import com.tripforbusiness.model.Login;
import com.tripforbusiness.model.User;
import com.tripforbusiness.model.UserDetails;
import com.tripforbusiness.repository.UserDetailsRepository;
import com.tripforbusiness.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "Execute login to the system")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDetails login(@RequestBody Login login) {

        List<User> userList = userRepository.findByEmail(login.getEmail());
        ScryptPasswordUtil scryptPasswordUtil = new ScryptPasswordUtil();
        UserDetails userDetails = new UserDetails();

        if (userList != null && !userList.isEmpty()) {
            if (scryptPasswordUtil.verifyUserPassword(login.getPassword(), userList.get(0).getPassword(),login.getEmail())) {
                userDetails = userDetailsRepository.findByUserId(userList.get(0).getId()).get(0);
            } else {
                userDetails.setErrorMessage("Your login is invalid. Please try again.");
            }
        }
        else {
            userDetails.setErrorMessage("Your login is invalid. Please try again.");
        }

        return userDetails;
    }
}
