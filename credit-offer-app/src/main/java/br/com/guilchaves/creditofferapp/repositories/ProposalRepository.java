package br.com.guilchaves.creditofferapp.repositories;

import br.com.guilchaves.creditofferapp.entities.Proposal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends CrudRepository<Proposal, Long> {
}
