package com.Car.CarRental.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Car.CarRental.Entity.Car;
import com.Car.CarRental.Repository.CarRepository;

@Service
public class CarService {

	@Autowired
	CarRepository CarRep;
	
	public List<Car> getAllCars(){
		return CarRep.findAll();
	}
	
	public Optional<Car> getACar(Long id){
		return CarRep.findById(id);
	}
	
	public void newCar(Car s) {
		CarRep.save(s);
	}
	
	public void removeCar(Long id) {
		CarRep.deleteById(id);
	}
	
	
}


