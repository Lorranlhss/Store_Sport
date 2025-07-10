package com.sportsstore.infrastructure;

import com.sportsstore.domain.ProductEntity;
import com.sportsstore.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // Limpar dados existentes
        repository.deleteAll();

        // Criar produtos de exemplo
        repository.save(new ProductEntity("Tênis Nike Air Max", new BigDecimal("299.99"),
                "Tênis esportivo com tecnologia Air Max para máximo conforto"));

        repository.save(new ProductEntity("Camisa Adidas Dry-Fit", new BigDecimal("89.99"),
                "Camisa esportiva com tecnologia Dry-Fit para treinos intensos"));

        repository.save(new ProductEntity("Bola Penalty S11", new BigDecimal("49.99"),
                "Bola oficial de futebol de campo"));

        repository.save(new ProductEntity("Luva Nike Goalkeeper", new BigDecimal("129.99"),
                "Luva profissional para goleiros"));

        repository.save(new ProductEntity("Shorts Puma Running", new BigDecimal("59.99"),
                "Shorts leve e confortável para corrida"));

        System.out.println("✅ Dados iniciais carregados: " + repository.count() + " produtos");
    }
}