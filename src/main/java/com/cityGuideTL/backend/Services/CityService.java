package com.cityGuideTL.backend.Services;



import com.cityGuideTL.backend.Entities.City;
import com.cityGuideTL.backend.Models.CityModel;
import com.cityGuideTL.backend.Repository.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
//TODO:map entities to models here
@Service
public class CityService {
    @Autowired
    private CitiesRepository citiesRepository;


    public City addCity(City city) {
        CityModel newCityModel = new CityModel();
        newCityModel.setPlaceId(city.getPlace_id());
        newCityModel.setLongitude(city.getLongitude());
        newCityModel.setLatitude(city.getLatitude());
        newCityModel.setWoe_name(city.getWoe_name());
        newCityModel.setContent(city.getContent());
        citiesRepository.save(newCityModel);
        return city;
    }


    public void deleteCity(Integer id) {
        CityModel city;
        try {
            city = citiesRepository.findById(id).orElseThrow(IOException::new);
        } catch (IOException e) {

            System.out.println("city not found");
            city=null;
        }
        citiesRepository.delete(city);
    }


    public CityModel getCity(Integer id) {
        CityModel city;
        try {
            city = citiesRepository.findById(id).orElseThrow(IOException::new);
        } catch (IOException e) {
            System.out.println("City not found");
            city = null;
        }
        return city;
    }


    public void updateCity(Integer id, CityModel city) {
        try {
            citiesRepository.findById(id).orElseThrow(IOException::new);
            citiesRepository.save(city);
        } catch(IOException e) {
            System.out.println("City of " + id.toString() + " not found");
        }
        
        
    }

    public List<CityModel> getAll(){
        List<CityModel> cities;
        try {
            cities = citiesRepository.findAll();
        } catch(Exception e) {
            System.out.println(e);
            cities = null;
        }
        return cities;
    }


	public Object findAll() {
		return null;
	}




}
