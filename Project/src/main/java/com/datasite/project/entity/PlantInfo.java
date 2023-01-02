package com.datasite.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PlantInfo extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Plant plant;


    @Column(nullable = false)
    private String sensormac;

    @Column(nullable = false)
    private float temperature;

    @Column(nullable = false)
    private float indoorHumidity;

    @Column(nullable = false)
    private float soilHumidity;

    @Column(nullable = false)
    private float illuminance;


    public void update(String sensormac, float temperature, float indoorHumidity, float soilHumidity, float illuminance){
        this.sensormac = sensormac;
        this.temperature = temperature;
        this.indoorHumidity = indoorHumidity;
        this.soilHumidity = soilHumidity;
        this.illuminance = illuminance;
    }

    public void delete(String sensormac, float temperature, float indoorHumidity, float soilHumidity, float illuminance){
        this.sensormac = sensormac;
        this.temperature = temperature;
        this.indoorHumidity = indoorHumidity;
        this.soilHumidity = soilHumidity;
        this.illuminance = illuminance;
    }
}
