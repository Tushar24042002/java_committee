package com.committee.demo.Service;


import com.committee.demo.Dto.UserVericationDto;
import com.committee.demo.Entity.Users.Users;
import com.committee.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public Users addOrUpdate(Users users) {
        users = userRepository.save(users);
        return users;
    }

    public Users deleteUser(Users user) {
        userRepository.deleteById(user.getId());
        return  user;
    }

    public Users addOrUpdateRoles(Users users) {
        return  users;
    }

    public Users verifyUser(UserVericationDto userVericationDto) {
Users user = userRepository.findByEmail(userVericationDto.getEmail());
if(user.getOtp().equals(userVericationDto.getOtp())){
    user.setVerified(true);
}
userRepository.save(user);
return user;

    }
}
