package com.datasite.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class PlantInfoResponseDto {
    private Long id;
    private String plantname;

    private String sensormac;

    private float temperature;

    private float indoorHumidity;

    private float soilHumidity;

    private float illuminance;

    private LocalDate createDate;
    private LocalTime createTime;
    private LocalDateTime createAt;
}
