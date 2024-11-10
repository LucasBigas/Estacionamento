package com.example.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.estacionamento.entity.ModeloVeiculo;
import com.example.estacionamento.service.ModeloVeiculoService;

@Controller
@RequestMapping("/modelos")
public class ModeloVeiculoController {
    
    @Autowired
    private ModeloVeiculoService service;

    @GetMapping
    public ModelAndView exibirFormulario() {
        ModelAndView modelAndView = new ModelAndView("modeloVeiculo"); // Define a view
        modelAndView.addObject("modelo", new ModeloVeiculo()); // Adiciona um objeto modelo vazio
        modelAndView.addObject("listaModelos", service.findAll()); // Adiciona a lista de modelos
        return modelAndView;
    }

    @PostMapping("/salvar")
    public ModelAndView salvarModelo(@ModelAttribute ModeloVeiculo modelo) {
        service.salvar(modelo); // Salva o novo modelo
        return new ModelAndView("redirect:/modelos"); // Redireciona de volta para o formulário
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        service.deletar(id);
        return new ModelAndView("redirect:/modelos");
    }
}
