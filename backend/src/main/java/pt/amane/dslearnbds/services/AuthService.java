package pt.amane.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pt.amane.dslearnbds.entities.User;
import pt.amane.dslearnbds.repositories.UserRepository;
import pt.amane.dslearnbds.services.exceptions.ForbiddenException;
import pt.amane.dslearnbds.services.exceptions.UnAuthorizedException;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			// pega utilizador autenticado..
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByEmail(username);
		} catch (Exception e) {
			throw new UnAuthorizedException("Invalid User!");
		}
	}
	
	// verifica se user é admin ou não.
	public void validateSelfOrAdmin(Long userId) {
		User user = authenticated();
		if(!user.getId().equals(userId) && !user.hasHole("ROLE_ADMIN")) {
			throw new ForbiddenException("Access danied!");
		}
	}
}
