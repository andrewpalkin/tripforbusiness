package com.tripforbusiness.controller;

import com.tripforbusiness.exception.LoginException;
import com.tripforbusiness.helper.ScryptPasswordUtil;
import com.tripforbusiness.model.Login;
import com.tripforbusiness.model.User;
import com.tripforbusiness.model.UserDetails;
import com.tripforbusiness.repository.UserDetailsRepository;
import com.tripforbusiness.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully login"),
            @ApiResponse(code = 401, message = "User are not authorized to do login"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")}
    )
    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDetails login(@RequestBody Login login){

        List<User> userList = userRepository.findByEmail(login.getEmail());
        ScryptPasswordUtil scryptPasswordUtil = new ScryptPasswordUtil();
        UserDetails userDetails;

        String ERROR_MESSAGE = "Access is denied due to invalid credentials. Please try again.";

        if (userList != null && !userList.isEmpty()) {
            if (scryptPasswordUtil.verifyUserPassword(login.getPassword(), userList.get(0).getPassword(), login.getEmail())) {
                userDetails = userDetailsRepository.findByUserId(userList.get(0).getId()).get(0);
            } else {
                throw new LoginException(ERROR_MESSAGE);
            }
        } else {
            throw new LoginException(ERROR_MESSAGE);
        }

        return userDetails;
    }
}
