package com.ammdev.financialaggregator.repository;

import com.ammdev.financialaggregator.entity.aggregate.CostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CostsRepository extends JpaRepository<CostEntity, Long> {

    Optional<List<CostEntity>> findByCostSource(String costSource);
}
