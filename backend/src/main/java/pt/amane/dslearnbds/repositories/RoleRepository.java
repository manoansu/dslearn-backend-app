package pt.amane.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.amane.dslearnbds.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
