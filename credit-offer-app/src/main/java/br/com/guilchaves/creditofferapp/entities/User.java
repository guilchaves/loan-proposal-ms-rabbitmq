package br.com.guilchaves.creditofferapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String document;
    private String phone;
    private Double income;

    @OneToOne(mappedBy = "user")
    private Proposal proposal;

}
