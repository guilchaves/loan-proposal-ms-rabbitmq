package br.com.guilchaves.creditofferapp.dto;

public class ProposalRequestDTO {

    private String name;
    private String lastName;
    private String phone;
    private String document;
    private Double income;
    private Double requestedAmount;
    private int loanRepaymentTermMonths;

    public ProposalRequestDTO() {
    }

    public ProposalRequestDTO(String name, String lastName, String phone, String document, Double income, Double requestedAmount, int loanRepaymentTermMonths) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.document = document;
        this.income = income;
        this.requestedAmount = requestedAmount;
        this.loanRepaymentTermMonths = loanRepaymentTermMonths;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
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
}
