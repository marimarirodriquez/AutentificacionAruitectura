package com.example.autetification.Infraestructure.Repositories.Imp;

import com.example.autetification.Domain.Entitys.Comprador;
import com.example.autetification.Domain.RepositoryContracts.CompradorRepository;
import com.example.autetification.Infraestructure.Repositories.CompradorRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompradorRepositoryImp implements CompradorRepository {

    @Autowired
    CompradorRepositoryJPA db;

    @Override
    public Comprador login(String user, String password) {
        return db.findByUserAndPassword(user,password);
    }

    public Comprador registrarComprador(Comprador comprador) {
        return db.save(comprador);
    }

}
