package br.com.guilchaves.creditofferapp.controllers;

import br.com.guilchaves.creditofferapp.dto.ProposalRequestDTO;
import br.com.guilchaves.creditofferapp.dto.ProposalResponseDTO;
import br.com.guilchaves.creditofferapp.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposal")
public class ProposalController {

    @Autowired
    private ProposalService service;

    @PostMapping
    public ResponseEntity<ProposalResponseDTO> create(@RequestBody ProposalRequestDTO requestDTO) {
        ProposalResponseDTO response = service.create(requestDTO);
        return ResponseEntity.ok(response);
    }


}
