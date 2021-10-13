package pt.amane.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.amane.dslearnbds.entities.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>{

}
