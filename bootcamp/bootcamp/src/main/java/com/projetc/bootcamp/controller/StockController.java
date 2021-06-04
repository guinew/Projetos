package com.projetc.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projetc.bootcamp.model.DTO.StockDTO;
import com.projetc.bootcamp.service.StockService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/stock")

public class StockController {
	
	@Autowired
	private StockService service;
	
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save (@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.ok(service.save(dto));
}
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update (@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(dto);
    }
    
    
    @GetMapping(value = "/")
    public ResponseEntity<List<StockDTO>> findAll(){
        List<StockDTO> List = new ArrayList<>();
        StockDTO dto = new StockDTO();
        dto.setId(3L);
        dto.setName("Ativo Guilherme");
                dto.setPrice(100D);
                        dto.setVariation(10D);
                            dto.setDate(LocalDate.now());
                            List.add(dto);

                                    return ResponseEntity.ok(List);

}
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
        List<StockDTO> List = new ArrayList<>();
        StockDTO stock1 = new StockDTO();
        stock1.setId(1L);
        stock1.setName("Ativo Antonio");
        stock1.setPrice(150D);
        stock1.setVariation(15D);
        stock1.setDate(LocalDate.now());
        StockDTO  stock2 = new StockDTO();
        stock2.setId(2L);
        stock2.setName("Ativo Gervasio");
        stock2.setPrice(200D);
        stock2.setVariation(5D);
        stock2.setDate(LocalDate.now());
        List.add(stock1);
        List.add(stock2);
        StockDTO dtoSelect = List.stream().filter(x -> x.getId().compareTo(id) == 0). findFirst().get();
        return ResponseEntity.ok(dtoSelect);



}

}
