package com.example.autetification.Domain.RepositoryContracts;

import com.example.autetification.Domain.Entitys.Vendedor;

public interface VendedorRepository {

    Vendedor login(String user, String password);
    Vendedor resitrarComprador(Vendedor vendedor);
}
