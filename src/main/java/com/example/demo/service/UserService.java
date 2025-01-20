package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserRepository;
import com.example.demo.model.User;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class UserService {
    UserRepository userRepository;

    public User createUser(User user){
       return userRepository.save(user);
    }

    public List<User> getAllUser(){
       return userRepository.findAll();
    }

    public void deleteUserById(String id){
        userRepository.deleteById(id);
    }

    public void update(String userID , User user){
        User user2 = userRepository.findById(userID).orElse(null);
        user2.setAddress(user.getAddress());
        user2.setEmail(user.getEmail());
        user2.setFullName(user.getFullName());
        user2.setOld(user.getOld());
        user2.setPhoneNumber(user.getPhoneNumber());
        userRepository.saveAndFlush(user2);
    }
}
