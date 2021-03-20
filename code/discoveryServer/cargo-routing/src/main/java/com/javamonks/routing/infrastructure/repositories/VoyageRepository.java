package com.javamonks.routing.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javamonks.routing.domain.model.aggregates.Voyage;

/**
 * Repository class for the Voyage Aggregate.
 */
public interface VoyageRepository extends JpaRepository<Voyage, Long> {
    /**
     * Find all Voyage Aggregates
     * @return
     */
    List<Voyage> findAll() ;


}
