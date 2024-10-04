package com.example.Desafio3.controllers;


import com.example.Desafio3.dto.ClientDTO;
import com.example.Desafio3.dto.CustomError;
import com.example.Desafio3.services.ClientService;
import com.example.Desafio3.services.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.HttpStatus;
import java.net.URI;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value="/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value ="/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
            ClientDTO dto = clientService.findById(id);
            return ResponseEntity.ok(dto);
        }
    @GetMapping
    public Page<ClientDTO> findAll(Pageable pageable){
        return clientService.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert( @Valid @RequestBody ClientDTO dto){
        dto = clientService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping(value ="/{id}")
    public ClientDTO update( @PathVariable Long id, @Valid @RequestBody ClientDTO dto){
        dto = clientService.update(id,dto);
        return dto;
    }
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> delete( @PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }




}
