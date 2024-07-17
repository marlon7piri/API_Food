package com.apiFood.service;

import com.apiFood.config.JwtProvider;
import com.apiFood.entities.user.User;
import com.apiFood.entities.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;


    @Override
    public User findUserByJwtToken(String jwt) throws Exception{

    String email = jwtProvider.getEmailFromJwtToken(jwt);
    User user = findUserByEmail(email);


        return user;
    }

    @Override
    public User findUserByEmail(String email)throws Exception{

        User user = userRepository.findByEmail(email);

        if(user==null){
             throw new Exception("User not found");
        }
        return user;
    }
}
