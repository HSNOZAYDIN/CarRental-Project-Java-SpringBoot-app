package com.Car.CarRental.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Car.CarRental.Entity.Car;
import com.Car.CarRental.Service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carSer;

    public CarController(CarService carSer) {
        this.carSer = carSer;
    }

    @GetMapping("/api")
    @ResponseBody
    public List<Car> getCarsApi() {
        return carSer.getAllCars();
    }

    @GetMapping("/api/{id}")
    @ResponseBody
    public Optional<Car> getCarApi(@PathVariable Long id) {
        return carSer.getACar(id);
    }

    @PostMapping("/api/save")
    @ResponseBody
    public String saveCarApi(@RequestBody Car car) {
        carSer.newCar(car);
        return "Car is Saved!";
    }

    @DeleteMapping("/api/{id}")
    @ResponseBody
    public String deleteCarApi(@PathVariable Long id) {
        carSer.removeCar(id);
        return "Car is Deleted!";
    }

    @GetMapping("/list")
    public String showCarList(Model model) {
        model.addAttribute("cars", carSer.getAllCars());
        model.addAttribute("car", new Car()); 
        return "carlist"; 
        
        
    }
    @PostMapping("/save")
    public String saveCar(@ModelAttribute("car") Car car) {
        carSer.newCar(car);
        return "redirect:/cars/list";  }

    @PostMapping("/{id}/delete")
    public String deleteCar(@PathVariable Long id) {
        carSer.removeCar(id);
        return "redirect:/cars/list";
    }  }

