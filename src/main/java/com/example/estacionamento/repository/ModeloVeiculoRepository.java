package com.example.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.estacionamento.entity.ModeloVeiculo;

@Repository
public interface ModeloVeiculoRepository extends JpaRepository<ModeloVeiculo , Long> {
    
}
