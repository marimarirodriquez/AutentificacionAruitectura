package com.example.autetification.Domain.Services;

import com.example.autetification.Domain.Entitys.Comprador;
import com.example.autetification.Domain.Entitys.Vendedor;
import com.example.autetification.Domain.RepositoryContracts.CompradorRepository;
import com.example.autetification.Domain.RepositoryContracts.VendedorRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final CompradorRepository compradorRepository;

    private final VendedorRepository vendedorRepository;


    public LoginService(CompradorRepository compradorRepository, VendedorRepository vendedorRepository) {
        this.compradorRepository = compradorRepository;
        this.vendedorRepository = vendedorRepository;
    }

    public Vendedor loginVendedor(String user, String password){
        return vendedorRepository.login(user,password);
    }

    public Comprador loginComprador(String user, String password){
        return compradorRepository.login(user,password);
    }
}
