package com.apiFood.service;


import com.apiFood.entities.user.User;

public interface UserServices{

    public User findUserByJwtToken(String jwt) throws Exception;


    public User findUserByEmail(String email)throws Exception;


}
