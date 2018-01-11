package com.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Disaster;
import com.example.entity.District;
import com.example.entity.Neighborhood;
import com.example.entity.Village;
import com.example.service.DisasterService;

import com.example.entity.City;


@Controller
public class DisasterController {

	 @Autowired
	private DisasterService disasterService;
	 
	 @GetMapping("/")
		public String home(HttpServletRequest request){
			request.setAttribute("mode", "MODE_HOME");
			return "index";
		}
	 
	 @GetMapping("/listdisasters")
		public String listDisasters(HttpServletRequest request){
			request.setAttribute("disasters", disasterService.listDisasters());
			request.setAttribute("mode", "MODE_DISASTERS");
			return "index";
		}
	 
	 @PostMapping("/savedisaster")
		public String saveDisaster(@ModelAttribute Disaster disaster,HttpServletRequest request){
		 	disasterService.saveDisaster(disaster);
			request.setAttribute("mode", "MODE_SAVE");
			List<Disaster> disasterList=disasterService.listDisasters();
			List<City> myCities=disasterService.listCities();
			
			String selectedCity= request.getParameter("nameOfCity"); //comboboxtan seçilen ile göre ilçe listesini günceller
			List<District> myDistricts=disasterService.listDistrictsByCity(selectedCity);
			
			String selectedDistrict= request.getParameter("nameOfDistrict"); //comboboxtan seçilen ilçeye göre köy listesini günceller
			 List<Village> myVillages= disasterService.listVillageByDistrict(selectedDistrict);
			 
			 String selectedVillage= request.getParameter("nameOfVillage"); //comboboxtan seçilen köye göre mahalle listesini oluşturur
			 List<Neighborhood> myNeighborhoods=disasterService.listNeighborhoodByVillage(selectedVillage);
			 
			 	request.setAttribute("alldisasters",disasterList );
				request.setAttribute("cities",myCities);
				request.setAttribute("districts",myDistricts);
				request.setAttribute("villages",myVillages);
				request.setAttribute("neighborhoods",myNeighborhoods);
			return "index";
		}
	 
	 @GetMapping("/updatedisaster")
		public String updateDisaster(@RequestParam int id, HttpServletRequest request){
		 request.setAttribute("mode", "MODE_UPDATE");
		 List<Disaster> disasterList=disasterService.listDisasters();
			List<City> myCities=disasterService.listCities();
			
			String selectedCity= request.getParameter("nameOfCity"); //comboboxtan seçilen ile göre ilçe listesini günceller
			List<District> myDistricts=disasterService.listDistrictsByCity(selectedCity);
			
			String selectedDistrict= request.getParameter("nameOfDistrict"); //comboboxtan seçilen ilçeye göre köy listesini günceller
			 List<Village> myVillages= disasterService.listVillageByDistrict(selectedDistrict);
			 
			 String selectedVillage= request.getParameter("nameOfVillage"); //comboboxtan seçilen köye göre mahalle listesini oluşturur
			 List<Neighborhood> myNeighborhoods=disasterService.listNeighborhoodByVillage(selectedVillage);
			 
			 	request.setAttribute("alldisasters",disasterList );
				request.setAttribute("cities",myCities);
				request.setAttribute("districts",myDistricts);
				request.setAttribute("villages",myVillages);
				request.setAttribute("neighborhoods",myNeighborhoods);
			return "index";
		}
		
		@GetMapping("/deletedisaster")
		public String deletetask(@RequestParam int id, HttpServletRequest request){
			disasterService.delete(id);
			request.setAttribute("disasters", disasterService.listDisasters());
			request.setAttribute("mode", "MODE_DELETE");
			return "index";
		}
		
		
}
