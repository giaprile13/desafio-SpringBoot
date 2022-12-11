package com.example.demo.repository;

import com.example.demo.entity.Dados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DadosRepository extends JpaRepository<Dados, UUID> {

}
