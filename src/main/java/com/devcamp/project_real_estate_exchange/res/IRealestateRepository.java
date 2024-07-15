package com.devcamp.project_real_estate_exchange.res;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.project_real_estate_exchange.entity.Realestate;

public interface IRealestateRepository extends JpaRepository<Realestate, Integer> {
    
}
