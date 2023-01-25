package com.vehicle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "details")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long  detailsId;
    @Column(name = "body")
    private String body;

    @Column(name = "model")
    private String model;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Column(name = "number_of_doors")
    private Integer numberOfDoors;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "engine")
    private String engine;

    @Column(name = "mileage")
    private Long mileage;

    @Column(name = "model_year")
    private Integer modelYear;

    @Column(name = "production_year")
    private Integer productionYear;

    @Column(name = "external_color")
    private String externalColor;
}
