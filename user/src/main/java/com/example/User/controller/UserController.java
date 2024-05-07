package com.example.User.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.User.model.User;
import com.example.User.model.dto.UserRequest;
import com.example.User.model.dto.UserResponse;
import com.example.User.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest userRequest) {

        User user = userService.register(userRequest);
        UserResponse res = UserResponse.builder()
        .username(user.getUsername())
        .id(user.getId())
        .build();

        System.out.println("Resposne :  " + res);
        return res;
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody UserRequest userRequest) {

        User user = userService.login(userRequest);
        UserResponse res = UserResponse.builder()
        .username(user.getUsername())
        .id(user.getId())
        .build();

        System.out.println("Resposne :  " + res);
        return res;
    }


//
//    @GetMapping()
//    public List<User> getAllUsersByUsername(@RequestParam Map<String, String> params) {
//        Integer page = Integer.parseInt(params.get("page"));
//        Integer size = Integer.parseInt(params.get("size"));
//        String username = params.get("username");
//        if (username == null) {
//            return userService.getAllUsers(page, size);
//        }
//        return userService.getUsersByUsername(page, size, username);
//    }
//
//    @PutMapping("/{userId}")
//    public UserResponse updateUser(@PathVariable Integer userId, @RequestBody UserRequest userRequest) {
//        User modifiedUser = User.builder()
//                .username(userRequest.getUsername())
//                .role(userRequest.getRole())
//                .build();
//        User user = userService.updateUser(userId, modifiedUser);
//        return UserResponse.builder()
//                .username(user.getUsername())
//                .id(userId)
//                .role(user.getRole())
//                .build();
//    }
//
//    @DeleteMapping("/{userId}")
//    public void updateUser(@PathVariable Integer userId) {
//        userService.deleteUser(userId);
//    }

}
