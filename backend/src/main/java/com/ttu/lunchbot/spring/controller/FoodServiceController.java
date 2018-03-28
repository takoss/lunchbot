package com.ttu.lunchbot.spring.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.ttu.lunchbot.spring.model.FoodService;
import com.ttu.lunchbot.spring.model.Menu;
import com.ttu.lunchbot.spring.service.FoodServiceService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class FoodServiceController {

    private FoodServiceService foodServiceService;

    public FoodServiceController(FoodServiceService foodServiceService) {
        this.foodServiceService = foodServiceService;
    }

    // TODO: Configure CORS globally so Aurelia can access data
    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping(value="/foodservices")
    public List<FoodService> getAllFoodServices() {
        return foodServiceService.getAllFoodServices();
    }

    // Shows /cafes properties plus menus
    @GetMapping(value="/foodservices/allinfo")
    public List<FoodService> getAllFoodServicesAllInfo() {
        return foodServiceService.getAllFoodServices();
    }

    @GetMapping(value = "/foodservices/{id}")
    public FoodService getFoodService(@PathVariable("id") long foodServiceId) {
        return foodServiceService.getFoodServiceById(foodServiceId);
    }

    // TODO: Configure CORS globally so Aurelia can access data
    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping(value = "/foodservices/{foodservice-id}/menus/today")
    public Menu getTodayMenuByFoodServiceId(@PathVariable("foodservice-id") long
                                                 foodServiceId) {
        return foodServiceService.getMenuOfToday(foodServiceId);
    }

    @PostMapping(value="/foodservices", consumes = "application/json")
    public FoodService addFoodService(@RequestBody FoodService foodService) {
        return foodServiceService.addFoodService(foodService);
    }

}
