package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CityRepository;
import com.example.dao.DisasterRepository;
import com.example.dao.DistrictRepository;
import com.example.dao.NeighborhoodRepo;
import com.example.dao.VillageRepository;
import com.example.entity.City;
import com.example.entity.Disaster;
import com.example.entity.District;
import com.example.entity.Neighborhood;
import com.example.entity.Village;




@Service
public class DisasterService {

	@Autowired
	private DisasterRepository disasterRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private VillageRepository villageRepository;
	
	@Autowired
	private NeighborhoodRepo neighborhoodRepo;
	
	public List<Disaster> listDisasters(){
		List<Disaster> disasters= new ArrayList<>();
		for (Disaster disaster : disasterRepository.findAll()) {
			disasters.add(disaster);
		}
		return disasters;
	}
	
	public void saveDisaster(Disaster disaster){
		disasterRepository.save(disaster);
	}
	
	public Disaster findDisaster(int id){
		return disasterRepository.findOne(id);
	}
	
	public void delete(int id){
		disasterRepository.delete(id);
	}
	
	public List<City> listCities(){
		List<City> cities= new ArrayList<>();
		for (City city : cityRepository.findAll()) {
			cities.add(city);
		}
		return cities;
	}
	
	public List<District> listDistrictsByCity(String city){
		List<District> districts= new ArrayList<>();
		for (District district : districtRepository.findByCity(city)) {
			districts.add(district);
		}
		return districts;
		//Hibernate ile aşağıdaki gibide yapılabilir:
		/*try {
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(District.class);
		criteria.add(Restrictions.eq("City.name", city));
		districts = criteria.list();
		trans.commit();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return districts;*/
	}
	
	public List<Village> listVillageByDistrict(String district){
		List<Village> villages= new ArrayList<>();
		for (Village village : villageRepository.findByDistrict(district)) {
			villages.add(village);
		}
		return villages;
	}
	
	public List<Neighborhood> listNeighborhoodByVillage(String village){
		List<Neighborhood> neighborhoods= new ArrayList<>();
		for (Neighborhood neighborhood : neighborhoodRepo.findByVillage(village)) {
			neighborhoods.add(neighborhood);
		}
		return neighborhoods;
	}
}
