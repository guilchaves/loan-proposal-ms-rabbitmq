package br.com.guilchaves.creditanalysis.domain;

public class Proposal {

    private Long id;
    private Double requestedAmount;
    private int loanRepaymentTermMonths;
    private Boolean approved;
    private boolean integrated;
    private String observation;
    private User user;

    public Proposal() {
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
