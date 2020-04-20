package com.entrenamientoSantander.microserv.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.entrenamientoSantander.microserv.dto.UserDTO;
import com.entrenamientoSantander.microserv.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	// GET
	@RequestMapping(method = RequestMethod.GET, params = { "id" })
	@ResponseBody
	public UserDTO findUserById(@RequestParam(value = "id") int id) {
		return userService.findUserById(id);
	}

	// GETALL
	@RequestMapping(method = RequestMethod.GET, value = "/getAll")
	@ResponseBody
	public List<UserDTO> findAllUsers() {
		return userService.findAll();
	}

	// CREATE
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	@ResponseBody
	public void createUser(@RequestBody @Valid UserDTO dto) {
		userService.create(dto);
	}

	// DELETE
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@RequestParam("id") int id) {
		userService.deleteUserById(id);
	}

	// UPDATE
	@RequestMapping(method = RequestMethod.PUT, params = { "id" }, value = "/update")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@RequestBody @Valid UserDTO user, @RequestParam(value = "id") int id) {
		user.setId(id);
		userService.updateUser(user);
	}

}
