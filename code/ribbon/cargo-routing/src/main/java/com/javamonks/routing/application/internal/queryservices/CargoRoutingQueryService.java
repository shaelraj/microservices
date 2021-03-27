package com.javamonks.routing.application.internal.queryservices;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.javamonks.routing.domain.model.aggregates.Voyage;
import com.javamonks.routing.infrastructure.repositories.VoyageRepository;

/**
 * Application Service class for the Cargo Routing Query service
 */
@Service
public class CargoRoutingQueryService {

    private VoyageRepository voyageRepository; // Inject Dependencies

    public CargoRoutingQueryService(VoyageRepository voyageRepository){
        this.voyageRepository = voyageRepository;
    }
    /**
     * Returns all Voyages
     * @return
     */
    @Transactional
    public List<Voyage> findAll(){
        return voyageRepository.findAll();
    }


}
