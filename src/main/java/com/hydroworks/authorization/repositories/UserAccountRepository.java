package com.hydroworks.authorization.repositories;

import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hydroworks.authorization.models.entities.UserAccount;

@Repository
public interface UserAccountRepository extends MongoRepository<UserAccount, ObjectId> {
    Optional<UserAccount> findByToken(String token);
}
