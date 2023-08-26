package com.desafio.vaga.controllers;

import com.desafio.vaga.entities.User;
import com.desafio.vaga.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/colaborador/validar/{id}")
    public ModelAndView validationUser(@PathVariable Long id) {
        var user = userService.findById(id);
        ModelAndView mv = new ModelAndView("validation");
        mv.addObject("user", user);
        return mv;
    }

    @PostMapping("/colaborador/validar/{id}")
    public ModelAndView valid(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("validation");
        userService.validation(id);
      return new ModelAndView("redirect:/registros");
    }

}
