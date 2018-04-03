package com.ttu.lunchbot.spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;


@Entity
@Getter
@Setter
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "menu_id", nullable = false, foreignKey = @ForeignKey(name = "menu_fk"))
    private Menu menu;

    @JsonProperty("name_et")
    @Column(name = "name_et")
    private String nameET;

    @JsonProperty("name_en")
    @Column(name = "name_en")
    private String nameEN;

    private BigDecimal price;

    private String currency;

    public MenuItem() {

    }

    public MenuItem(String nameET, String nameEN, Menu menu, Currency currency, BigDecimal price) {
        this.nameET = nameET;
        this.nameEN = nameEN;
        this.menu = menu;
        this.currency = currency.toString();
        this.price = price.setScale(2, RoundingMode.HALF_UP);
    }

}
