package pt.amane.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.amane.dslearnbds.entities.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long>{

}
