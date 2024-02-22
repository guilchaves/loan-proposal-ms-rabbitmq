package br.com.guilchaves.creditofferapp.entity;

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
}
