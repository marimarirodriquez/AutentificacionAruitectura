package com.example.autetification.Infraestructure.Repositories;

import com.example.autetification.Domain.Entitys.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepositoryJPA extends JpaRepository<Comprador,Integer> {
    Comprador findByUserAndPassword(String user, String password);

    Comprador findByIdShopper(Integer id);


}