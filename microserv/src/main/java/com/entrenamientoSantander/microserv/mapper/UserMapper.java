package com.entrenamientoSantander.microserv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.entrenamientoSantander.microserv.dto.UserDTO;
import com.entrenamientoSantander.microserv.entity.UserEntity;

@Mapper
public interface UserMapper {
	
	@Mappings({
		
		@Mapping(target = "id", source="id"),
		@Mapping(target = "name", source="name"),
		@Mapping(target = "surname", source="surname"),
		@Mapping(target = "email", source="email")
		
	})
	UserDTO toDTO(UserEntity entity);
	
	@Mappings({
		
		@Mapping(target = "id", source="id"),
		@Mapping(target = "name", source="name"),
		@Mapping(target = "surname", source="surname"),
		@Mapping(target = "email", source="email")
		
	})
	UserEntity toEntity(UserDTO dto);

}
