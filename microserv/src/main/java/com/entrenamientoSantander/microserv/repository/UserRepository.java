package com.entrenamientoSantander.microserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entrenamientoSantander.microserv.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>, JpaRepository<UserEntity, Integer>{
	
	UserEntity findById(int id);
	UserEntity findByName(String name);

}
