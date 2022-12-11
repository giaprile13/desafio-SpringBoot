package com.example.demo.controller;

import com.example.demo.entity.Dados;
import com.example.demo.service.DadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/demo")
public class DadosController {

    @Autowired
    private DadosService dadosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dados salvar(@RequestBody Dados dados){
        return dadosService.salvar(dados);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Dados> listaDados(){
        return dadosService.listaDados();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dados buscarDadoPorId(@PathVariable("id") UUID id) {
        return dadosService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerDado(@PathVariable("id") UUID id){
        dadosService.buscarPorId(id)
                .map(dados -> {
                    dadosService.removerPorId(dados.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
}