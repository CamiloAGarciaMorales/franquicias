package com.nequi.controller;


import com.nequi.model.FranquiciaEntity;
import com.nequi.repositories.FranquiciaRepository;
import com.nequi.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Mono<FranquiciaEntity> createFranquicia(@RequestBody FranquiciaEntity franquicia)
    {
        return franquiciaRepository.save(franquicia);
    }

}
