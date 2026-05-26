package com.portifole.web.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user") //cria tabela no banco de dados
@Getter //CRIA GETTERS AUTOMATICO
@Setter //CRIA SETTERS AUTOMATICO
public class User  implements Serializable {

    // Garante compatibilidade ao converter objeto em bytes (rede/cache/sessão)
    private static final long serialVersionUID = 1L;

    @Id //Indica que o atributo é a chave primária da tabela
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY) //Gera o valor automaticamente (auto-incremento)
    private  Long id;
    private String name;
    private String email;
    private String phone;
    private  String password;


    @Setter(AccessLevel.NONE) //Impede que o setter seja gerado para a lista de pedidos, garantindo que a lista seja manipulada apenas através dos métodos da classe
    @OneToMany(mappedBy = "client") //Indica que a associação é mapeada pelo atributo "client" na classe Order
    private List<Order> orders = new ArrayList<>(); //Associação com a classe Order (um usuário pode ter vários pedidos)

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

