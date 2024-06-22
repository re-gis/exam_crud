package com.jusish.exam.serviceImpl;

import com.jusish.exam.classes.Address;
import com.jusish.exam.dtos.CreateUserDto;
import com.jusish.exam.dtos.UpdateUserDto;
import com.jusish.exam.enums.URole;
import com.jusish.exam.models.User;
import com.jusish.exam.repositories.UserRepository;
import com.jusish.exam.services.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public String createUser(CreateUserDto dto) throws Exception {
        try{
            if(dto.getName() == null || dto.getEmail() == null || dto.getPassword() == null || dto.getAddress().getDistrict() == null || dto.getAddress().getSector() == null){
                throw new BadRequestException("All user details are required...");
            }else{
                User user = new User();
                user.setAddress(dto.getAddress());
                user.setName(dto.getName());
                user.setEmail(dto.getEmail());
                user.setPassword(dto.getPassword());
                user.setRole(dto.getRole());
                userRepository.save(user);
                return "User created successfully...";
            }

        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String deleteUser(long id) throws Exception {
        try{
            User user = userRepository.findById(id).orElseThrow(() -> new Exception(String.format("User %d not found!", id)));
            userRepository.delete(user);
            return "User deleted successfully...";
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public User updateUser(UpdateUserDto dto, long id) throws Exception {
        try{
            User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found!"));
            String name = dto.getName() == null ? user.getName() : dto.getName();
            String email = dto.getEmail() == null ? user.getEmail() : dto.getEmail();
            String password = dto.getPassword() == null ? user.getPassword() : dto.getPassword();
            URole role = dto.getRole() == null ? user.getRole() : dto.getRole();
            Address address = dto.getAddress() == null ? user.getAddress() : dto.getAddress();

            user.setAddress(address);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole(role);
            userRepository.save(user);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public User getUser() throws Exception {
        return null;
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return null;
    }
}
