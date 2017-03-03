package meiit.controller;

import meiit.service.User;
import meiit.service.UserService;

public class UserControllerImpl implements UserController {

	private final UserService userService;

	
	public UserControllerImpl(UserService userService) {
		super();
		this.userService = userService;
	}

	public void addUser(String userName) {
		User user = new User();
		user.setUserName(userName);

		userService.save(user);
	}

}
