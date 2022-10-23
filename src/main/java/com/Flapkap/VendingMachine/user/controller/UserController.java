package com.Flapkap.VendingMachine.user.controller;

import com.Flapkap.VendingMachine.user.dto.ResponseWithLongId;
import com.Flapkap.VendingMachine.user.dto.UserDto;
import com.Flapkap.VendingMachine.user.dto.request.StoreUserRequest;
import com.Flapkap.VendingMachine.user.dto.request.UpdateUserRequest;
import com.Flapkap.VendingMachine.user.service.UserMapper;
import com.Flapkap.VendingMachine.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
@Validated
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;


    @GetMapping()
    ResponseEntity<?> ListAll() {
        return new ResponseEntity<>(userService.listUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable Long id) {
        return userMapper.map(userService.getUserById(id));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable Long id,
                           @Validated @RequestBody UpdateUserRequest request) {
        userService.updateUser(id, request);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }





}
