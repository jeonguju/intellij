package com.datasite.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlantInfoRequestDto {
    private long plantId;

    private String sensormac;

    private float temperature;

    private float indoorHumidity;

    private float soilHumidity;

    private float illuminance;
}


//TimeStamped