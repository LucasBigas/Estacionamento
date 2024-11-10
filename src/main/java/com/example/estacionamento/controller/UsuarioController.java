package com.example.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.estacionamento.entity.Usuario;
import com.example.estacionamento.service.UsuarioService;
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    @GetMapping
    public ModelAndView findAll() {
        var listaUsuarios = service.findAll();
  
        return new ModelAndView("listaUsuarios", "listaUsuarios", listaUsuarios);   
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var usuario = new Usuario();
        return new ModelAndView("cadastro", "usuario", usuario);
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(Usuario usuario){
        service.save(usuario);
        return new ModelAndView("redirect:/usuarios");
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletar(@PathVariable ("id") Long id){
        service.deleteById(id);
        return new ModelAndView("redirect:/usuarios");
    }
}


