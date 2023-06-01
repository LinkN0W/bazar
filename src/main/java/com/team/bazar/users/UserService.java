package com.team.bazar.users;

import com.team.bazar.security.jwt.JwtService;
import com.team.bazar.security.message.responses.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean canRegister(String nickName, String email) {
        if (!userRepository.findUserByName(nickName).isEmpty()) {
            return false;
        }
        if (!userRepository.findUserByEmail(email).isEmpty()) {
            return false;
        }
        return true;

    }


    public void save(User user){
        userRepository.save(user);
    }

    public User getUserByName(String name){
        return userRepository.findUserByName(name).get();

    }

    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email).get();
    }
}
