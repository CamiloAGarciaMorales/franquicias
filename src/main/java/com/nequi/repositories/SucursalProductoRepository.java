package com.nequi.repositories;

import com.nequi.model.SucursalProductoEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface SucursalProductoRepository extends ReactiveCrudRepository<SucursalProductoEntity, Long> {
    Mono<SucursalProductoEntity> findBySucursalIdAndProductoId(Long sucursalId, Long productoId);
}

