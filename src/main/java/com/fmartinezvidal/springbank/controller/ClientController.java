package com.fmartinezvidal.springbank.controller;

import com.fmartinezvidal.springbank.model.Client;
import com.fmartinezvidal.springbank.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final IClientService clientService;

    @GetMapping("/client/{id}")
    public Client findById(@PathVariable long id) {
        return clientService.findById(id);
    }

    @PostMapping("/client")
    public Client create(@RequestBody Client client) {
        return clientService.create(client);
    }
}
