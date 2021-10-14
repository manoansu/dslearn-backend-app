package pt.amane.dslearnbds.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pt.amane.dslearnbds.dtos.UserDTO;
import pt.amane.dslearnbds.entities.User;
import pt.amane.dslearnbds.repositories.UserRepository;
import pt.amane.dslearnbds.services.exceptions.ObjectNotFoundException;

@Service
public class UserService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> userId = repository.findById(id);
		User user = userId.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id:" + id + ", Type: " + User.class.getName()));
		return new UserDTO(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repository.findByEmail(username);
		if (user == null) {
			logger.error("Email not found! " + username);
			throw new UsernameNotFoundException("Email not found!");
		}
		logger.info("User found success! " + username);
		return user;
	}

}
