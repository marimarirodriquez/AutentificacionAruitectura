package com.example.autetification.Application.Controllers;

import com.example.autetification.Application.Converters.CompradorConverter;
import com.example.autetification.Application.Converters.VendedorConverter;
import com.example.autetification.Application.Dto.CompradorDto;
import com.example.autetification.Application.Dto.VendedorDto;
import com.example.autetification.Application.utils.WrapperResponse;
import com.example.autetification.Domain.Entitys.Comprador;
import com.example.autetification.Domain.Entitys.Vendedor;
import com.example.autetification.Domain.Services.LoginService;
import com.example.autetification.Domain.Services.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("")
public class AutentificatorController {
    private final CompradorConverter compradorConverter;
    private final VendedorConverter vendedorConverter;

    private  final LoginService loginService;

    private final RegisterService registerService;

    public AutentificatorController(CompradorConverter compradorConverter, VendedorConverter vendedorConverter, LoginService loginService, RegisterService registerService) {
        this.compradorConverter = compradorConverter;
        this.vendedorConverter = vendedorConverter;
        this.loginService = loginService;
        this.registerService = registerService;
    }

    @PostMapping("/comprador/login")
    public ResponseEntity<WrapperResponse<CompradorDto>> loginComprador(@RequestBody CompradorDto compradorDto) throws Exception{
        Comprador comprador=compradorConverter.fromDTO(compradorDto);
        String user = comprador.getUser();
        String password = comprador.getPassword();
        Comprador compradorNew=null;

        if(user!=null && password!=null){
            compradorNew=loginService.loginComprador(user,password);
        }
        if(compradorNew==null){
            throw new Exception("Malas Credenciales");
        }
        CompradorDto response = compradorConverter.fromEntity(compradorNew);
        return new WrapperResponse<CompradorDto>(true,"success",response)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping("/vendedor/login")
    public ResponseEntity<WrapperResponse<VendedorDto>> loginVendedor(@RequestBody VendedorDto vendedordto) throws Exception {
        Vendedor vendedor= vendedorConverter.fromDTO(vendedordto);
        String user = vendedor.getUser();
        String password = vendedor.getPassword();
        Vendedor vendedorNew = null;
        if (user != null && password != null) {
            vendedorNew = loginService.loginVendedor(user, password);
        }
        if (vendedorNew == null) {
            throw new Exception("Malas Credenciales");
        }
        VendedorDto response= vendedorConverter.fromEntity(vendedorNew);
        return new WrapperResponse<VendedorDto>(true,"success",response)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping("/comprador/resgister")
    public ResponseEntity<WrapperResponse<CompradorDto>> registrarComprador(@Valid @RequestBody CompradorDto compradorDto){
        Comprador comprador= compradorConverter.fromDTO(compradorDto);
        Comprador compradorNew=registerService.registrarComprador(comprador);
        CompradorDto response= compradorConverter.fromEntity(compradorNew);
        return new WrapperResponse<CompradorDto>(true,"success",response)
                .createResponse(HttpStatus.CREATED);
    }
    @PostMapping("/vendedor/resgister")
    public ResponseEntity<WrapperResponse<VendedorDto>> registrarVendedor(@Valid @RequestBody VendedorDto vendedorDto){
        Vendedor vendedor= vendedorConverter.fromDTO(vendedorDto);
        Vendedor vendedorNew=registerService.registrarVendedor(vendedor);
        VendedorDto response = vendedorConverter.fromEntity(vendedorNew);
        return new WrapperResponse<VendedorDto>(true,"success",response)
                .createResponse(HttpStatus.CREATED);
    }
}
