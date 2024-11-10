package com.example.estacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estacionamento.entity.ModeloVeiculo;
import com.example.estacionamento.repository.ModeloVeiculoRepository;

@Service
public class ModeloVeiculoService {

    @Autowired
    private ModeloVeiculoRepository repository;

    public List<ModeloVeiculo> findAll() {
        return repository.findAll();
    }

    public ModeloVeiculo salvar(ModeloVeiculo modeloVeiculo) {
        return repository.save(modeloVeiculo);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
