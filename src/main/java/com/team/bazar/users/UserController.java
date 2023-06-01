package com.team.bazar.users;

import com.team.bazar.members.entities.Listener;
import com.team.bazar.members.entities.Member;
import com.team.bazar.members.factories.ListenerCreator;
import com.team.bazar.members.factories.MemberCreator;
import com.team.bazar.members.servicies.MemberService;
import com.team.bazar.security.jwt.JwtService;
import com.team.bazar.security.jwt.UserPrinciple;
import com.team.bazar.security.message.requests.LoginRequest;
import com.team.bazar.security.message.requests.RegisterRequest;
import com.team.bazar.security.message.responses.JwtResponse;
import com.team.bazar.security.message.responses.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MemberService memberService;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request){
        if(!this.userService.canRegister(request.getName(), request.getEmail()))
           return new ResponseEntity<>(new ResponseMessage("Email / Nickname is already in use"),
                    HttpStatus.BAD_REQUEST);

        User user = new User(UUID.randomUUID(),
                request.getEmail(),
                request.getName(),
                passwordEncoder.encode(request.getPassword()),
                User.UserRole.USER);

        MemberCreator listenerCreator = new ListenerCreator();
        Member listener = listenerCreator.makeMember(user);

        userService.save(user);
        //memberService.save((Listener) listener);

        UserPrinciple userPrinciple = UserPrinciple.build(user);
        String jwtToken = jwtService.generateToken(userPrinciple);

        System.out.println(jwtToken);
        return new ResponseEntity<>(new ResponseMessage("User registration is successful"), HttpStatus.OK);
    }


    @PostMapping("/signin")
    public ResponseEntity<?> register(@RequestBody LoginRequest request){

        User userEntity;
        if(request.getEmail() == null){
            userEntity = this.userService.getUserByName(request.getUsername());
        }else{
            userEntity = this.userService.getUserByEmail(request.getEmail());
        }
        System.out.println(userEntity.getEmail()+" "+userEntity.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userEntity.getEmail(), request.getPassword()));



        String jwt = jwtService.generateToken((UserPrinciple) authentication.getPrincipal());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }
}