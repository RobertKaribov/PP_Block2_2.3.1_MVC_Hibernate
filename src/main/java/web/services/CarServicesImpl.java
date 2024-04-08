package web.services;

import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServicesImpl implements CarServices {

    private final List<Car> carList = new ArrayList<>();

    public CarServicesImpl() {
        carList.add(new Car("BMW", "X5", "Red"));
        carList.add(new Car("Audi", "A4", "Blue"));
        carList.add(new Car("Mercedes", "E-Class", "Silver"));
        carList.add(new Car("Toyota", "Camry", "White"));
        carList.add(new Car("Honda", "Civic", "Black"));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count >= carList.size()) {
            return carList;
        } else {
            return carList.subList(0, count);
        }
    }

    @Override
    public List<Car> getAllCars() {
        return carList;
    }
}