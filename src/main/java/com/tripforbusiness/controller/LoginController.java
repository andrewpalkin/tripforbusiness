package com.tripforbusiness.controller;

import com.tripforbusiness.model.Login;
import com.tripforbusiness.model.UserDetails;
import com.tripforbusiness.repository.UserDetailsRepository;
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

    @ApiOperation(value = "Execute login to the system")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDetails> login(@RequestBody Login login) {
        return userDetailsRepository.findByEmail(login.getEmail());
    }
}
