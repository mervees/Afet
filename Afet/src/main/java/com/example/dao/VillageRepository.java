package com.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.entity.District;
import com.example.entity.Village;

public interface VillageRepository extends CrudRepository<Village, Integer>{

	public List<Village> findByDistrict(String district);
	}


