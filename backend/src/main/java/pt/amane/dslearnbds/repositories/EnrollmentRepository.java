package pt.amane.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.amane.dslearnbds.entities.Enrollment;
import pt.amane.dslearnbds.entities.pk.EnrollmentPk;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPk>{

}
