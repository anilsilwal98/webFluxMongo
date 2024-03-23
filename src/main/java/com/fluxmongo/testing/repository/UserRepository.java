package com.fluxmongo.testing.repository;

import com.fluxmongo.testing.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
/*
 Note
    The repository pattern is a design pattern that provides an abstraction layer
    between the data persistence layer and the business logic layer of an application.
 */