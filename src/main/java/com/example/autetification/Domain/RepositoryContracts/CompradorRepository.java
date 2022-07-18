package com.example.autetification.Domain.RepositoryContracts;

import com.example.autetification.Domain.Entitys.Comprador;

public interface CompradorRepository {
    Comprador login(String user, String password);
    Comprador registrarComprador(Comprador comprador);
}
