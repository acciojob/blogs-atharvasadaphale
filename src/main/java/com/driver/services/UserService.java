package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    @Autowired
    BlogService blogService3;

    public void createUser(User user){
        userRepository3.save(user);
        //By cascading effect, child will automatically be saved (cardRepo will be saved)
    }

    public void deleteUser(int userId){
        User user= userRepository3.findById(userId).get();

        userRepository3.delete(user);
    }

    public void updateUser(User user){
        User originaluser = userRepository3.findById(user.getId()).get();

        //We will keep the other properties as it is : and only change the required parameters

        originaluser.setPassword(user.getPassword());

        userRepository3.save(user);
    }

    public User findUserByUsername(String username){

        //custom query
        return userRepository3.findByUsername(username);
    }
}
