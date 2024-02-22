package br.com.guilchaves.creditofferapp.services;

import br.com.guilchaves.creditofferapp.dto.ProposalRequestDTO;
import br.com.guilchaves.creditofferapp.dto.ProposalResponseDTO;
import br.com.guilchaves.creditofferapp.entities.Proposal;
import br.com.guilchaves.creditofferapp.repositories.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposalService {

    @Autowired
    private ProposalRepository repository;

    public ProposalResponseDTO create(ProposalRequestDTO requestDTO){
        repository.save(new Proposal());
        return null;
    }
}
