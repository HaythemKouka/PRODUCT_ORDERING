package com.example.ProdOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.example.ProdOrder",         // résolveurs, services, contrôleurs
    "resolvers" // si tu as des sous-packages spécifiques
})
@EntityScan(basePackages = {
    "entities"    // entités JPA
})
@EnableJpaRepositories(basePackages = {
    "repo" // interfaces extends JpaRepository
})
public class ProdOrder { 

    public static void main(String[] args) {
        SpringApplication.run(ProdOrder.class, args);
    }
}
