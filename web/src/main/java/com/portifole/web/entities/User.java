package com.portifole.web.entities;


import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter //CRIA GETTERS AUTOMATICO
public class User  implements Serializable {

    // Garante compatibilidade ao converter objeto em bytes (rede/cache/sessão)
    private static final long serialVersionUID = 1L;

    private  Long id;
    private String name;
    private String email;
    private String phone;
    private  String password;

    public  User(){
    }

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}

