package hu.iit.miskolc.zelena.webalk.service;

import java.util.List;

import hu.iit.miskolc.zelena.webalk.validators.*;

public class UserServiceImpl implements IUserService {

	private final List<Ivalidator> validators;
	private final UserRepository userRepository;
	
	
	public UserServiceImpl(List<Ivalidator> validators, UserRepository userRepository) {
		super();
		this.validators = validators;
		this.userRepository = userRepository;
	}
	
	public void save(User user) {
		for (Ivalidator validator : validators){
			if (!validator.isValid(user.getUserName())){
				return;
			}
			userRepository.save(user);
		}
	}

}
