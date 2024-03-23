package com.fluxmongo.testing.Service;

import com.fluxmongo.testing.model.User;
import com.fluxmongo.testing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public Mono<User> saveUser(final User user){
        return userRepository.save(user);
    }

    public Mono<User> findById(final  String id){
        return userRepository.findById(id);
    }

    public Mono<User> updateUser( final User user, final String userId){
        return userRepository.findById(userId)
                .flatMap(dbUser -> {
                    dbUser.setAddress(user.getAddress());
                    return userRepository.save(dbUser);
                });
    }

    public Flux<User> getAllUser(){
        return userRepository.findAll();
    }

    // complex query
    public Flux<User> fetchUser(final String name){
        Query query = new Query();
        query.with(Sort.by(Collections.singletonList(Sort.Order.asc("dob"))))
                .addCriteria(Criteria.where("lName").regex(name))
        ;
        return reactiveMongoTemplate.find(query, User.class);

    }


}
