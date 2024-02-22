package br.com.guilchaves.creditofferapp.controllers;

import br.com.guilchaves.creditofferapp.dto.ProposalRequestDTO;
import br.com.guilchaves.creditofferapp.dto.ProposalResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposal")
public class ProposalController {

    @PostMapping
    public ResponseEntity<ProposalResponseDTO> create(@RequestBody ProposalRequestDTO requestDTO){
        return null;
    }



}
