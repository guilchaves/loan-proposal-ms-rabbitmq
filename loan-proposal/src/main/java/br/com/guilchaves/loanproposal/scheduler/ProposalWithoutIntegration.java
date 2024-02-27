package br.com.guilchaves.loanproposal.scheduler;

import br.com.guilchaves.loanproposal.entities.Proposal;
import br.com.guilchaves.loanproposal.repositories.ProposalRepository;
import br.com.guilchaves.loanproposal.services.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ProposalWithoutIntegration {

    private final ProposalRepository repository;
    private final NotificationService notificationService;
    private final String exchange;

    public ProposalWithoutIntegration(ProposalRepository repository,
                                      NotificationService notificationService,
                                      @Value("${rabbitmq.proposalpending.exchange}")
                                      String exchange) {
        this.repository = repository;
        this.notificationService = notificationService;
        this.exchange = exchange;
    }

    private final Logger logger = LoggerFactory.getLogger(ProposalWithoutIntegration.class);

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void searchProposalsWithoutIntegration(){
        repository.findAllByIntegratedIsFalse().forEach(proposal -> {
            try {
                notificationService.sendNotification(proposal, exchange);
                updateProposal(proposal);
            } catch (RuntimeException ex){
                logger.error(ex.getMessage());
            }
        });
    }

    private void updateProposal(Proposal proposal) {
        proposal.setIntegrated(true);
        repository.save(proposal);
    }
}
