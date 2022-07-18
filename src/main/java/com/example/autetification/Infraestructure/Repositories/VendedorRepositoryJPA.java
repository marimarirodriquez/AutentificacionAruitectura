package com.example.autetification.Infraestructure.Repositories;


import com.example.autetification.Domain.Entitys.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepositoryJPA extends JpaRepository<Vendedor, Integer> {
    Vendedor findByUserAndPassword(String user, String password);
    Vendedor findByIdVendedor(Integer id);

}
