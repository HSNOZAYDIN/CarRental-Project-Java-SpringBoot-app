package com.Car.CarRental.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Car.CarRental.Entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}


