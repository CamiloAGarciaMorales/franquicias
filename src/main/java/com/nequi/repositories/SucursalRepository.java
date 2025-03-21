package com.nequi.repositories;

import com.nequi.model.SucursalEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface SucursalRepository extends ReactiveCrudRepository<SucursalEntity, Long> {
    Mono<SucursalEntity> findById(Long id);
}
