package br.com.guilchaves.creditofferapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProposalRequestDTO {

    private String name;
    private String lastName;
    private String phone;
    private String document;
    private Double income;
    private Double requestedAmount;
    private int loanRepaymentTermMonths;

}
