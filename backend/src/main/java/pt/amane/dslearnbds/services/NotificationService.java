package pt.amane.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pt.amane.dslearnbds.dtos.NotificationDTO;
import pt.amane.dslearnbds.entities.Notification;
import pt.amane.dslearnbds.entities.User;
import pt.amane.dslearnbds.repositories.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private AuthService authService;
	
	public Page<NotificationDTO> notificationsForCurrentUser(Pageable pageable){
		User user = authService.authenticated();
		Page<Notification> listUser = repository.findByUser(user, pageable);
		return listUser.map(x -> new NotificationDTO(x));
	}

}
