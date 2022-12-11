package com.example.demo.service;

import com.example.demo.entity.Dados;
import com.example.demo.repository.DadosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DadosService {

     final DadosRepository dadosRepository;

    public DadosService(DadosRepository dadosRepository) {
        this.dadosRepository = dadosRepository;
    }

    @Transactional
    public Dados salvar(Dados dados){
        return dadosRepository.save(dados);
    }
    public List<Dados> listaDados(){
        return dadosRepository.findAll();
    }

    public Optional<Dados> buscarPorId(UUID id){
        return dadosRepository.findById(id);
    }

    public void removerPorId(UUID id){
        dadosRepository.deleteById(id);
    }
}
