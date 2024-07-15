package com.devcamp.project_real_estate_exchange.res;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.project_real_estate_exchange.entity.Province;

public interface IProvinceRepository extends JpaRepository<Province, Integer> {
    
}
