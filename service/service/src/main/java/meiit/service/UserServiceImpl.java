package meiit.service;

import java.util.List;

import meiit.validators.Validator;

public class UserServiceImpl implements UserService {

	private final List<Validator> validators;
	private final UserRepository userRepository;

	public UserServiceImpl(List<Validator> validators, UserRepository userRepository) {
		this.validators = validators;
		this.userRepository = userRepository;
	}
	@Override
	public void save(User user) {
		for (Validator validator : validators) {
			if (validator.isValid(user.getUserName())) {
				return;
			}
		}

		userRepository.save(user);
	}

}
