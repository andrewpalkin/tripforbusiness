package com.tripforbusiness.repository;

import com.tripforbusiness.model.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {

    List<UserDetails> findByUserId(String userId);

}
