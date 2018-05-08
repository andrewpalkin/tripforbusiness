package com.tripforbusiness.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document(collection = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated User Object ID", hidden = true)
    private String id;
    @ApiModelProperty(notes = "The User name", required = true)
    private String name;
    @ApiModelProperty(notes = "The User email", required = true)
    private String email;
    @ApiModelProperty(notes = "The User Id that was auto generated on stage of user creation")
    private String userId;
    @ApiModelProperty(notes = "The User role (user, admin, etc)")
    private String userRole;
    @ApiModelProperty(notes = "Retrieve error message in case user not found or email not match")
    private String errorMessage;

    protected String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
