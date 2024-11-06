package com.example.crud.services;

import com.example.crud.dtos.ExceptionDTO;
import com.example.crud.dtos.UserDTO;
import com.example.crud.entities.User;
import com.example.crud.exceptions.ExceptionHandlerController;
import com.example.crud.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO userDto){
        User user = new User(userDto.fullName(), userDto.email(), userDto.password());
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User getUserById(String id) throws Exception{
        return this.userRepository.findById(UUID.fromString(id)).orElseThrow(EntityNotFoundException::new);
    }

    public User updateUser(String id, UserDTO userDto)throws Exception{
        User user = this.userRepository.findById(UUID.fromString(id)).orElseThrow(EntityNotFoundException::new);
        user.Update(userDto.fullName(), userDto.email(), userDto.password());
        return this.userRepository.save(user);
    }

    public void deleteUser(String id)throws Exception{
        User user = this.userRepository.findById(UUID.fromString(id)).orElseThrow(EntityNotFoundException::new);
        this.userRepository.delete(user);
    }

}
