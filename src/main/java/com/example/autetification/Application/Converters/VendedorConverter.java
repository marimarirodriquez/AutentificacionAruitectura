package com.example.autetification.Application.Converters;

import com.example.autetification.Application.Dto.VendedorDto;
import com.example.autetification.Domain.Entitys.Vendedor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VendedorConverter extends AbstractConverter<Vendedor, VendedorDto> {


    @Override
    public VendedorDto fromEntity(Vendedor entity) {
        if (entity == null)
            return null;

        return VendedorDto.builder()
                .idVendedor(entity.getIdVendedor())
                .user(entity.getUser())
                .password(entity.getPassword())
                .phone(entity.getPhone())
                .name(entity.getName())
                .departamento(entity.getDepartamento())
                .provincia(entity.getProvincia())
                .distrito(entity.getDistrito())
                .direccion(entity.getDireccion())
                .longitud(entity.getLongitud())
                .latitud(entity.getLatitud())
                .build();
    }

    @Override
    public Vendedor fromDTO(VendedorDto dto) {
        if (dto == null)
            return null;

        return Vendedor.builder()
                .idVendedor(dto.getIdVendedor())
                .user(dto.getUser())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .name(dto.getName())
                .departamento(dto.getDepartamento())
                .provincia(dto.getProvincia())
                .distrito(dto.getDistrito())
                .direccion(dto.getDireccion())
                .latitud(dto.getLatitud())
                .longitud(dto.getLongitud())
                .build();
    }
}
