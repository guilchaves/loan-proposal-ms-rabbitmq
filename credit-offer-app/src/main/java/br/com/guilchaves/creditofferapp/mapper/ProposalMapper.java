package br.com.guilchaves.creditofferapp.mapper;

import br.com.guilchaves.creditofferapp.dto.ProposalRequestDTO;
import br.com.guilchaves.creditofferapp.entities.Proposal;
import org.mapstruct.Mapper;

@Mapper
public interface ProposalMapper {

    Proposal convertDtoToProposal(ProposalRequestDTO proposalRequest);
}
