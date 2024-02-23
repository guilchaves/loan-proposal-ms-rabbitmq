package br.com.guilchaves.creditofferapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_proposal")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double requestedAmount;
    private int loanRepaymentTermMonths;
    private Boolean approved;
    private boolean integrated;
    private String observation;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Proposal() {
    }

    public Proposal(Long id, Double requestedAmount, int loanRepaymentTermMonths, Boolean approved, boolean integrated, String observation, User user) {
        this.id = id;
        this.requestedAmount = requestedAmount;
        this.loanRepaymentTermMonths = loanRepaymentTermMonths;
        this.approved = approved;
        this.integrated = integrated;
        this.observation = observation;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(Double requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public int getLoanRepaymentTermMonths() {
        return loanRepaymentTermMonths;
    }

    public void setLoanRepaymentTermMonths(int loanRepaymentTermMonths) {
        this.loanRepaymentTermMonths = loanRepaymentTermMonths;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public boolean isIntegrated() {
        return integrated;
    }

    public void setIntegrated(boolean integrated) {
        this.integrated = integrated;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
