package com.ttu.lunchbot.spring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.ttu.lunchbot.spring.controller.Views;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "food_services")
public class FoodService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.NoFoodServiceMenus.class)
    private long id;

    @OneToMany(mappedBy = "foodService")
    @JsonManagedReference
    private List<Menu> menus = new ArrayList<>();

    @JsonView(Views.NoFoodServiceMenus.class)
    String name;

    @Column(name = "menu_url")
    String menuURL;

    String website;

    String lon;

    String lat;

    public FoodService() {
    }

    public FoodService(String name) {
        this.name = name;
    }
}