package com.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.entity.Neighborhood;
import com.example.entity.Village;

public interface NeighborhoodRepo extends CrudRepository<Neighborhood, Integer>{

	public List<Neighborhood> findByVillage(String village);
	}


