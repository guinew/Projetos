package com.projetc.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetc.bootcamp.mapper.StockMapper;
import com.projetc.bootcamp.model.Stock;
import com.projetc.bootcamp.model.DTO.StockDTO;
import com.projetc.bootcamp.repository.StockRepository;

@Service
public class StockService {

	
	@Autowired	
	private StockRepository	repository;
	
	@Autowired		
	private StockMapper mapper;
	

	@Transactional
	public StockDTO save(StockDTO dto) {
		Stock stock = mapper.toEntity(dto);
		repository.save(stock);
		return mapper.toDto(stock);	
	}
}
