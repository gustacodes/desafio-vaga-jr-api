package com.desafio.vaga.controllers;

import com.desafio.vaga.entities.User;
import com.desafio.vaga.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/colaborador/registrar")
    public ResponseEntity<User> save(@RequestBody User user) {
        user.setStatus(false);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @GetMapping("/registros")
    public ResponseEntity<List<User>> listAll() {
        return ResponseEntity.ok().body(userService.listAll());
    }

    @PutMapping("/colaborador/validar/{id}")
    public ResponseEntity<User> validation(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.validation(id));
    }

}
