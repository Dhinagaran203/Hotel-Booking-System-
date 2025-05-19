package com.project.hotelbookingapp.service;

import java.util.List;

import com.project.hotelbookingapp.model.User;
import com.project.hotelbookingapp.model.dto.ResetPasswordDTO;
import com.project.hotelbookingapp.model.dto.UserDTO;
import com.project.hotelbookingapp.model.dto.UserRegistrationDTO;

public interface UserService {

    User saveUser(UserRegistrationDTO registrationDTO);

    // For registration
    User findUserByUsername(String username);

    UserDTO findUserDTOByUsername(String username);

    UserDTO findUserById(Long id);

    List<UserDTO> findAllUsers();

    void updateUser(UserDTO userDTO);

    void updateLoggedInUser(UserDTO userDTO);

    void deleteUserById(Long id);

    User resetPassword(ResetPasswordDTO resetPasswordDTO);

}
