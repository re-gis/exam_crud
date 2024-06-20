package com.jusish.exam.services;

import com.jusish.exam.dtos.CreateUserDto;
import com.jusish.exam.dtos.UpdateUserDto;
import com.jusish.exam.models.User;

import java.util.List;

public interface UserService {
    String createUser(CreateUserDto dto)throws Exception;

    String deleteUser(long id)throws Exception;

    User updateUser(UpdateUserDto dto, long id) throws Exception;

    User getUser()throws Exception;

    List<User> getAllUsers()throws Exception;
}
