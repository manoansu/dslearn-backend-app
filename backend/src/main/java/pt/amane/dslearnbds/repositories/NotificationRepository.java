package pt.amane.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.amane.dslearnbds.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
