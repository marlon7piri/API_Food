package com.apiFood.entities.user;


import com.apiFood.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserControllers {


    @Autowired
    private UserServices userServices;



    @GetMapping("/profile")
    public ResponseEntity<User> findUserByJwtToken(@RequestHeader("Authorization") String jwt) throws  Exception{
        User user = userServices.findUserByJwtToken(jwt);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }


}
