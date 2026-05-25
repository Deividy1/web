package com.portifole.web.resources;

import com.portifole.web.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users") //ENDPOINT PARA ACESSAR O RECURSO
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Maria","maria@gmail.com","999999","12345");
        return ResponseEntity.ok().body(u);
    }
}
