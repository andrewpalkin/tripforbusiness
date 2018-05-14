package com.tripforbusiness.controller;

import com.tripforbusiness.exception.LoginException;
import com.tripforbusiness.helper.ScryptPasswordUtil;
import com.tripforbusiness.model.User;
import com.tripforbusiness.model.UserDetails;
import com.tripforbusiness.repository.UserDetailsRepository;
import com.tripforbusiness.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    private static String ERROR_MESSAGE = "Access is denied due to invalid credentials. Please try again.";

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "Execute login to the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully login"),
            @ApiResponse(code = 400, message = "An exception is thrown when request missing parameter etc."),
            @ApiResponse(code = 401, message = "User are not authorized to do login"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @RequestMapping(method = RequestMethod.GET)
    public UserDetails login(@ApiParam(value = "Email of User", required = true) @RequestParam("email") String email,
                             @ApiParam(value = "Password of User", required = true) @RequestParam("pass") String password) {

        List<User> userList = userRepository.findByEmail(email);
        ScryptPasswordUtil scryptPasswordUtil = new ScryptPasswordUtil();
        UserDetails userDetails;

        if (userList != null && !userList.isEmpty()) {
            if (scryptPasswordUtil.verifyUserPassword(password, userList.get(0).getPassword(), email)) {
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
