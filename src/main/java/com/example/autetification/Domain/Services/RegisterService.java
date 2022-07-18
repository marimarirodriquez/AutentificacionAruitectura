package com.example.autetification.Domain.Services;

import com.example.autetification.Domain.Entitys.Comprador;
import com.example.autetification.Domain.Entitys.Vendedor;
import com.example.autetification.Domain.RepositoryContracts.CompradorRepository;
import com.example.autetification.Domain.RepositoryContracts.VendedorRepository;

import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final CompradorRepository compradorRepository;

    private final VendedorRepository vendedorRepository;

    public RegisterService(CompradorRepository compradorRepository, VendedorRepository vendedorRepository) {
        this.compradorRepository = compradorRepository;
        this.vendedorRepository = vendedorRepository;
    }

    public Comprador registrarComprador(Comprador comprador) {
        comprador.setStatus("activo");
        return compradorRepository.registrarComprador(comprador);
    }

    public Vendedor registrarVendedor(Vendedor vendedor) {
        return vendedorRepository.resitrarComprador(vendedor);
    }

}
