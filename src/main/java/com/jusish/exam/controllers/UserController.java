package com.jusish.exam.controllers;

import com.jusish.exam.dtos.CreateUserDto;
import com.jusish.exam.dtos.UpdateUserDto;
import com.jusish.exam.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody CreateUserDto dto)throws Exception{
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMapping(@PathVariable("id") long id)throws Exception{
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody UpdateUserDto dto, @PathVariable("id") Long id)throws Exception{
        return ResponseEntity.ok(userService.updateUser(dto, id));
    }
}
