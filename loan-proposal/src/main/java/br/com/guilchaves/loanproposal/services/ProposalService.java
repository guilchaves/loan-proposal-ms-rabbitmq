package br.com.guilchaves.loanproposal.services;

import br.com.guilchaves.loanproposal.dto.ProposalRequestDTO;
import br.com.guilchaves.loanproposal.dto.ProposalResponseDTO;
import br.com.guilchaves.loanproposal.entities.Proposal;
import br.com.guilchaves.loanproposal.mappers.ProposalMapper;
import br.com.guilchaves.loanproposal.repositories.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalService {

    @Autowired
    private ProposalRepository repository;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    @Value("${rabbitmq.proposalpending.exchange}")
    private String exchange;

    public List<ProposalResponseDTO> findAll() {
        Iterable<Proposal> proposals = repository.findAll();
        return ProposalMapper.INSTANCE.convertListEntityToListDto(proposals);
    }

    public ProposalResponseDTO insert(ProposalRequestDTO requestDTO) {
        Proposal proposal = ProposalMapper.INSTANCE.convertDtoToEntity(requestDTO);
        repository.save(proposal);
        notifyRabbitMQ(proposal);
        return ProposalMapper.INSTANCE.convertEntityToDto(proposal);
    }

    private void notifyRabbitMQ(Proposal proposal){
        try {
            notificationService.sendNotification(proposal, exchange);
        } catch (RuntimeException ex){
            proposal.setIntegrated(false);
            repository.save(proposal);
        }
    }
}
