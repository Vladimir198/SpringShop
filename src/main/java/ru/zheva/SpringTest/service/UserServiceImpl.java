package ru.zheva.SpringTest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ru.zheva.SpringTest.dao.UserRepository;
import ru.zheva.SpringTest.domain.Role;
import ru.zheva.SpringTest.domain.User;
import ru.zheva.SpringTest.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findFirstByName(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(user.getRole().name()));

		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), roles);
	}

	@Override
	public boolean save(UserDTO userDTO) {
		if (!Objects.equals(userDTO.getPassword(), userDTO.getMatchingPassword())) {
			throw new RuntimeException("Пароль не подходит");

		}
		User user = User.builder().name(userDTO.getUsername()).password(passwordEncoder.encode(userDTO.getPassword())).email(userDTO.getEmail()).role(Role.CLIENT).build();
		userRepository.save(user);
		return true;
	}

}
