package com.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.City;
import com.example.entity.District;


public interface DistrictRepository extends CrudRepository<District, Integer>{

	public List<District> findByCity(String city);
	}

