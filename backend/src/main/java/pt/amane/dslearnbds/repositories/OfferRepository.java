package pt.amane.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.amane.dslearnbds.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>{

}
