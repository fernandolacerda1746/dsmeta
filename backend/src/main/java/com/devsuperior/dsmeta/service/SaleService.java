package com.devsuperior.dsmeta.service;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	public Page<Sale> findSales(String MinDate, String MaxDate, Pageable pageable){
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = MinDate.equals("")? today.minusDays(365) : LocalDate.parse(MinDate);
		LocalDate max = MaxDate.equals("")? today : LocalDate.parse(MaxDate);
		
		return repository.findSales(min, max, pageable);
		
	}

}
