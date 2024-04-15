package com.committee.demo.Controllers;

import com.committee.demo.Dto.UserVericationDto;
import com.committee.demo.Entity.Email.Email;
import com.committee.demo.Entity.Roles.Roles;
import com.committee.demo.Entity.Users.Users;
import com.committee.demo.Service.EmailService;
import com.committee.demo.Service.OtpService;
import com.committee.demo.Service.UserService;
import com.committee.demo.Utils;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    EmailService emailService;


    @GetMapping("/")
    public String getName(){
        return "hello tushar";
    }

    @PostMapping("/addOrUpdate")
    public ResponseEntity<Users> addOrUpdateUser(@RequestBody Users users) {
        Utils utils = new Utils();
        String otp = utils.generateOtp();
        users.setOtp(otp);
        Users savedUser = userService.addOrUpdate(users);
        String responseMessage;

        if (users.getVerified() == null) {



            Email email = new Email();
            email.setToEmail(users.getEmail());

            email.setSubject("Email Verification from Committee");
            emailService.sendEmail(email);

            responseMessage = "New user added successfully and please verify email";
        } else responseMessage = "User updated successfully.";

        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);

    }

    @PostMapping("/deleteUser")
    public ResponseEntity<Users> deleteUser(@RequestBody Users user){
        Users users = userService.deleteUser(user);
        return  new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PostMapping("userRoles")
    public ResponseEntity<Users> addOrupdateRoles(@RequestBody Users users){
        users  = userService.addOrUpdateRoles(users);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @PostMapping("verification")
    public ResponseEntity<Users> verifyUser(@RequestBody UserVericationDto userVericationDto){
        Users user  = userService.verifyUser(userVericationDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
