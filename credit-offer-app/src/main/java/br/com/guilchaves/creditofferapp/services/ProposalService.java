package br.com.guilchaves.creditofferapp.services;

import br.com.guilchaves.creditofferapp.dto.ProposalRequestDTO;
import br.com.guilchaves.creditofferapp.dto.ProposalResponseDTO;
import br.com.guilchaves.creditofferapp.entities.Proposal;
import br.com.guilchaves.creditofferapp.mappers.ProposalMapper;
import br.com.guilchaves.creditofferapp.repositories.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalService {

    @Autowired
    private ProposalRepository repository;

    @Autowired
    private NotificationService notificationService;

    public List<ProposalResponseDTO> findAll() {
        Iterable<Proposal> proposals = repository.findAll();
        return ProposalMapper.INSTANCE.convertListEntityToListDto(proposals);
    }

    public ProposalResponseDTO insert(ProposalRequestDTO requestDTO) {
        Proposal proposal = ProposalMapper.INSTANCE.convertDtoToEntity(requestDTO);
        repository.save(proposal);

        ProposalResponseDTO response = ProposalMapper.INSTANCE.convertEntityToDto(proposal);
        notificationService.notifiy(response, "proposal-pending.ex");

        return response;
    }

}
