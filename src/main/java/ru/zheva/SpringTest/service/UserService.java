package ru.zheva.SpringTest.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import ru.zheva.SpringTest.dto.UserDTO;

public interface UserService extends UserDetailsService { // для securiti
	boolean save(UserDTO userDTO);

}
