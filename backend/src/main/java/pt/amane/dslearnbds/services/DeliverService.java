package pt.amane.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pt.amane.dslearnbds.dtos.DeliverRevisionDTO;
import pt.amane.dslearnbds.entities.Deliver;
import pt.amane.dslearnbds.repositories.DeliverRepository;

@Service
public class DeliverService {
	
	@Autowired
	private DeliverRepository repository;
	
	@PreAuthorize(value = "hasAnyRole('ADMIN', 'INSTRUCTOR')")
	@Transactional
	public void saveRevision(Long id, DeliverRevisionDTO dto) {
		Deliver deliver = repository.getOne(id);
		deliver.setCorrectCount(dto.getCorrectCount());
		deliver.setStatus(dto.getStatus());
		deliver.setFeedback(dto.getFeedback());
		repository.save(deliver);
	}

}
