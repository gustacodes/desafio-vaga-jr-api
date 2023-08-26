package com.desafio.vaga.controllers;

import com.desafio.vaga.entities.User;
import com.desafio.vaga.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/colaborador/registrar")
    public String save() {
        return "index";
    }

    @PostMapping("/colaborador/registrar")
    public ModelAndView save( User user) {
        ModelAndView mv = new ModelAndView("index");
        user.setStatus(false);
        userService.save(user);
        return new ModelAndView("redirect:/registros");
    }

    @GetMapping("/registros")
    public ModelAndView listAll() {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("list", userService.listAll());
        return mv;
    }

    @PutMapping("/colaborador/validar/{id}")
    public ResponseEntity<User> validation(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.validation(id));
    }

}
