package com.bill.service;

import java.util.List;

import com.bill.dto.UserDTO;
import com.bill.entity.User;

public interface UserService {

	User registerUser(User user);

	User getUserById(Long id);

	List<UserDTO> getAllUsers();

	User updateUser(Long id, User userDetails);

	void deleteUser(Long id);

}
