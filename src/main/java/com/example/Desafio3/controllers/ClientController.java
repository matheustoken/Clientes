package com.example.Desafio3.controllers;


import com.example.Desafio3.dto.ClientDTO;
import com.example.Desafio3.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value ="/{id}")
    public ClientDTO findById(@PathVariable Long id){
        ClientDTO dto = clientService.findById(id);
        return dto;
    }
    @GetMapping
    public Page<ClientDTO> findAll(Pageable pageable){
        return clientService.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto){
        dto = clientService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping(value ="/{id}")
    public ClientDTO update( @PathVariable Long id,@RequestBody ClientDTO dto){
        dto = clientService.update(id,dto);
        return dto;
    }
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> delete( @PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }




}
