package br.com.guilchaves.creditofferapp.controllers;

import br.com.guilchaves.creditofferapp.dto.ProposalRequestDTO;
import br.com.guilchaves.creditofferapp.dto.ProposalResponseDTO;
import br.com.guilchaves.creditofferapp.services.ProposalService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/proposal")
public class ProposalController {

    @Autowired
    private ProposalService service;

    @GetMapping
    public ResponseEntity<List<ProposalResponseDTO>> findAll(){
        List<ProposalResponseDTO> proposals = service.findAll();
        return ResponseEntity.ok(proposals);
    }

    @PostMapping
    public ResponseEntity<ProposalResponseDTO> insert(@RequestBody ProposalRequestDTO dto) {
        ProposalResponseDTO response = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }


}
