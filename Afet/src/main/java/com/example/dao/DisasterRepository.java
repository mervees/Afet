package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Disaster;

public interface DisasterRepository extends CrudRepository<Disaster, Integer>{

}
