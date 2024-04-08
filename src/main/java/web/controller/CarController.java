// CarController.java
package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.services.CarServices;

import java.util.List;

@Controller
public class CarController {

    private final CarServices carServices;

    public CarController(CarServices carServices) {
        this.carServices = carServices;
    }

    @GetMapping("/cars")
    public String getCars(Model model, @RequestParam(required = false) Integer count) {
        List<Car> cars;
        if (count != null && count >= 0 && count < carServices.getAllCars().size()) {
            cars = carServices.getCars(count);
        } else {
            cars = carServices.getAllCars();
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
