package com.laptrinhweb.Convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhweb.DTO.UserDTO;
import com.laptrinhweb.Entity.CustomerEntity;
import com.laptrinhweb.Entity.LoginEntity;
import com.laptrinhweb.repository.CustomerRepository;
import com.laptrinhweb.repository.LoginRepository;

@Component
public class User {
	@Autowired
	CustomerRepository userRepository;
	@Autowired
	LoginRepository loginRepository;
	public CustomerEntity toEntity(UserDTO user) {
		return userRepository.findById(user.getId()).get();
	}
	public UserDTO toDTO(CustomerEntity user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setAddress(user.getAddress());
		userDTO.setEmail(user.getEmail());
		userDTO.setImage(user.getImage());
		for (LoginEntity x: loginRepository.findAll()) {
			if (x.getCustomer().getId() == user.getId()) {
				userDTO.setUsername(x.getUsername());
			}
		}
		userDTO.setPhone(user.getPhone());
		if (user.getSex() == true) userDTO.setSex("Nam");
		else userDTO.setSex("Nữ");
		userDTO.setFullname(user.getName());
		return userDTO;
	}
}
