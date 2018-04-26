package com.tripforbusiness.helper;

import com.tripforbusiness.model.User;
import com.tripforbusiness.repository.UserRepository;

import java.util.List;

public class UserValidationUtil {

    public boolean userAlreadyExist(UserRepository userRepository, User user) {

       List<User> userList = userRepository.findByEmail(user.getEmail());

       return userList != null && !userList.isEmpty();
    }
}
