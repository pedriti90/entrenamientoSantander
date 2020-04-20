package com.entrenamientoSantander.microserv.service;

import java.util.List;

import com.entrenamientoSantander.microserv.dto.UserDTO;

public interface UserService {
	
	public UserDTO findUserById(int id);
	
	public List<UserDTO> findAll();
	
	public UserDTO create(UserDTO dto);
	
	public UserDTO updateUser(UserDTO dto);
	
	public void deleteUserById(int id);

}
