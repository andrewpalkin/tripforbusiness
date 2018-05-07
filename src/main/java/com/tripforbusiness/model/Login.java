package com.tripforbusiness.model;

import io.swagger.annotations.ApiModelProperty;

public class Login {

    @ApiModelProperty(notes = "The User email", required = true)
    private String email;
    @ApiModelProperty(notes = "The User password", required = true)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
