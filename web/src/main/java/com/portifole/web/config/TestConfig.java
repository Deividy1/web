package com.portifole.web.config;

import com.portifole.web.entities.User;
import com.portifole.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Array;
import java.util.Arrays;

@Configuration //Indica que a classe é uma classe de configuração do Spring
@Profile("test") //Indica que essa configuração só será ativa quando o perfil "test" estiver ativo

public class TestConfig implements CommandLineRunner {

    @Autowired //Injeta a dependência do UserRepository para usar em métodos de configuração
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2)); //Salva os objetos no banco de dados usando o repositório
    }
}
