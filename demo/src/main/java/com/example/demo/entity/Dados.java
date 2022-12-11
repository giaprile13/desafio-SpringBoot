package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Dados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    @Column(name = "peso", nullable = false)
    public Double peso;
    @Column(name = "altura", nullable = false)
    public Double altura;
}
