package com.projetc.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetc.bootcamp.model.Stock;
import com.projetc.bootcamp.model.DTO.StockDTO;

@Repository	
public interface StockRepository extends JpaRepository<Stock, Long>{

	void save(StockDTO dto);

}
