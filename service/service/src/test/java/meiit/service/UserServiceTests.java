package meiit.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import meiit.validators.Validator;


public class UserServiceTests {

	@Test
	public void construction() {
		List<Validator> validators = new ArrayList<>();
		UserRepository userRepository = Mockito.mock(UserRepository.class);

		UserService userService = new UserServiceImpl(validators, userRepository);
	}

	@Test
	public void saveWithEmptyValidators() {
		List<Validator> validators = new ArrayList<>();
		UserRepository userRepository = Mockito.mock(UserRepository.class);
		UserService userService = new UserServiceImpl(validators, userRepository);

		User user = new User();
		user.setUserName("aaaa");

		userService.save(user);

		Mockito.verify(userRepository).save(user);
	}

	@Test
	public void saveWithFalseValidators() {
		List<Validator> validators = new ArrayList<>();
		Validator falseValidator = Mockito.mock(Validator.class);
		Mockito.when(falseValidator.isValid(Mockito.anyString())).thenReturn(false);

		validators.add(falseValidator);

		UserRepository userRepository = Mockito.mock(UserRepository.class);
		UserService userService = new UserServiceImpl(validators, userRepository);

		User user = new User();
		user.setUserName("aaaa");

		userService.save(user);

		Mockito.verify(userRepository, Mockito.times(0)).save(user);
	}

	@Test
	public void saveWithTrueValidators() {
		List<Validator> validators = new ArrayList<>();
		Validator trueValidator = Mockito.mock(Validator.class);
		Mockito.when(trueValidator.isValid(Mockito.anyString())).thenReturn(true);

		validators.add(trueValidator);

		UserRepository userRepository = Mockito.mock(UserRepository.class);
		UserService userService = new UserServiceImpl(validators, userRepository);

		User user = new User();
		user.setUserName("aaaa");

		userService.save(user);

		Mockito.verify(userRepository).save(user);
	}

	@Test
	public void saveWithTrueFalseValidators() {
		List<Validator> validators = new ArrayList<>();
		Validator trueValidator = Mockito.mock(Validator.class);
		Mockito.when(trueValidator.isValid(Mockito.anyString())).thenReturn(true);

		validators.add(trueValidator);

		Validator falseValidator = Mockito.mock(Validator.class);
		Mockito.when(falseValidator.isValid(Mockito.anyString())).thenReturn(false);

		validators.add(falseValidator);

		UserRepository userRepository = Mockito.mock(UserRepository.class);
		UserService userService = new UserServiceImpl(validators, userRepository);

		User user = new User();
		user.setUserName("aaaa");

		userService.save(user);

		Mockito.verify(userRepository, Mockito.times(0)).save(user);
	}
}
