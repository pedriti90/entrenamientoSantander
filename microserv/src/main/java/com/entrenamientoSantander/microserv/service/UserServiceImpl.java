package com.entrenamientoSantander.microserv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrenamientoSantander.microserv.dto.UserDTO;
import com.entrenamientoSantander.microserv.entity.UserEntity;
import com.entrenamientoSantander.microserv.mapper.UserMapper;
import com.entrenamientoSantander.microserv.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	UserMapper mapper;
	
	public UserDTO findUserById(int id) {
		return mapper.toDTO(repository.findById(id));
	}

	public List<UserDTO> findAll() {
		List<UserDTO> resultado = new ArrayList<UserDTO>();
		for(UserEntity entity : repository.findAll()) {
			resultado.add(mapper.toDTO(entity));
		}
		return resultado;
	}

	public UserDTO create(UserDTO dto) {
		repository.save(mapper.toEntity(dto));
		return dto;
	}

	public UserDTO updateUser(UserDTO input) {
		UserDTO dtoBBDD = this.findUserById(input.getId());
		UserDTO result = new UserDTO();
		
		if(dtoBBDD != null) {
			UserEntity entity = mapper.toEntity(dtoBBDD);
			entity.setName(input.getName());
			entity.setSurname(input.getSurname());
			entity.setEmail(input.getEmail());
			result = mapper.toDTO(repository.save(entity));
			return result;
		} else {
			return null;
		}
	}

	public void deleteUserById(int id) {
		UserDTO dtoBBDD = this.findUserById(id);
		if(dtoBBDD != null) {
			repository.deleteById(id);
		}
	}

}
