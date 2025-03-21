package com.nequi.controller;

import com.nequi.model.SucursalEntity;
import com.nequi.repositories.FranquiciaRepository;
import com.nequi.repositories.SucursalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/sucursales")
public class SucursalController {

    private final FranquiciaRepository franquiciaRepository;
    private final SucursalRepository   sucursalRepository;

    public SucursalController(FranquiciaRepository franquiciaRepository, SucursalRepository sucursalRepository) {
        this.franquiciaRepository = franquiciaRepository;
        this.sucursalRepository = sucursalRepository;
    }

    @PostMapping
    public Mono<ResponseEntity<SucursalEntity>> agregarSucursal(@RequestBody SucursalEntity sucursal){
        return franquiciaRepository.findById(sucursal.getFranquiciaId())
                .flatMap(franquicia -> {
                    sucursal.setFranquiciaId(franquicia.getId());
                    return sucursalRepository.save(sucursal);
                }).map(sucursalSaved -> ResponseEntity.status(HttpStatus.CREATED).body(sucursalSaved))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
