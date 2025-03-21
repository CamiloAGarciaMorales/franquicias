package com.nequi.controller;


import com.nequi.model.FranquiciaEntity;
import com.nequi.repositories.FranquiciaRepository;
import com.nequi.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("api/franquicias")
public class FranquiciasController {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    //Agregar una franquicia nueva
    @PostMapping
    public Mono<ResponseEntity<String>> createFranquicia(@RequestBody FranquiciaEntity franquicia)
    {
        return franquiciaRepository.save(franquicia).map(productoGuardado -> ResponseEntity.status(HttpStatus.CREATED).body("Franquicia Creada"))
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al Crear la franquicia")));
    }

}
