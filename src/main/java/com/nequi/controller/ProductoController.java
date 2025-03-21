package com.nequi.controller;

import com.nequi.model.FranquiciaEntity;
import com.nequi.model.ProductoEntity;
import com.nequi.repositories.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/productos")
public class ProductoController {
    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @PostMapping
    public Mono<ResponseEntity<String>> agregarProducto(@RequestBody ProductoEntity producto){
        return productoRepository.save(producto)
                .map(productoGuardado -> ResponseEntity.status(HttpStatus.CREATED).body("producto Creado"))
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al Crear el producto")));
    }


}
