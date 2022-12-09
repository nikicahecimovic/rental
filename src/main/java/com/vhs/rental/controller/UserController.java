//package com.vhs.rental.controller;
//
//import com.vhs.rental.form.UserForm;
//import com.vhs.rental.model.User;
//import com.vhs.rental.service.UserService;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collections;
//
//@RestController
//@RequestMapping("/api/user")
//public class UserController {
//
//    private final UserService userService;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    public UserController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @PostMapping("/add")
//    public User addUser(@RequestBody UserForm userForm){
//        return userService.save(userForm);
//    }
//
//    @PostMapping("/login")
//    public void login(@RequestParam String username, @RequestParam String password) {
//        // Find the user by username
//        User user = userService.findByUsername(username);
//        if (user == null) {
//            throw new BadCredentialsException("Invalid username or password");
//        }
//        // Verify the password
//        boolean passwordMatches = passwordEncoder.matches(password, user.getPassword());
//        if (!passwordMatches) {
//            throw new BadCredentialsException("Invalid username or password");
//        }
//        // If the password matches, log the user in
//        SecurityContextHolder.getContext().setAuthentication(
//                new UsernamePasswordAuthenticationToken(user, null, Collections.singleton(new SimpleGrantedAuthority(user.getRole()))));
//    }
//
//    @PostMapping("/logout")
//    public void logout() {
//        SecurityContextHolder.clearContext();
//    }
//
//}
