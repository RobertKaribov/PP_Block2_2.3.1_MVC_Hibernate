// CarService.java
package web.services;

import web.models.Car;

import java.util.List;

public interface CarServices {
    List<Car> getCars(int count);
    List<Car> getAllCars();
}