package com.fmartinezvidal.springbank.controller;

import com.fmartinezvidal.springbank.model.Client;
import com.fmartinezvidal.springbank.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.HttpStatus.NO_CONTENT;

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

    @GetMapping("/clients")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @PutMapping("/client/{id}")
    public Client update(@PathVariable long id, @RequestBody Client dataNewClient) {
        return clientService.update(id ,dataNewClient);
    }
    @ResponseStatus(code = NO_CONTENT)
    @DeleteMapping("/client/{id}")
    public void delete(@PathVariable long id) {
        clientService.delete(id);
    }
}
