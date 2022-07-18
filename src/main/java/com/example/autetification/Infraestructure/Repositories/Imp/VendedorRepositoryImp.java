package com.example.autetification.Infraestructure.Repositories.Imp;

import com.example.autetification.Domain.Entitys.Vendedor;
import com.example.autetification.Domain.RepositoryContracts.VendedorRepository;
import com.example.autetification.Infraestructure.Repositories.VendedorRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendedorRepositoryImp implements VendedorRepository {

    @Autowired
    VendedorRepositoryJPA db;

    @Override
    public Vendedor login(String user, String password) {
        return db.findByUserAndPassword(user,password);
    }

    @Override
    public Vendedor resitrarComprador(Vendedor vendedor) {
        return db.save(vendedor);
    }
}
