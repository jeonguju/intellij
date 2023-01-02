package com.datasite.project.service;

import com.datasite.project.dto.PlantInfoRequestDto;
import com.datasite.project.dto.PlantInfoResponseDto;
import com.datasite.project.dto.PlantRequestDto;
import com.datasite.project.dto.PlantResponseDto;
import com.datasite.project.entity.Plant;
import com.datasite.project.entity.PlantInfo;
import com.datasite.project.repository.PlantInfoRepository;
import com.datasite.project.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantService {
    private final PlantRepository plantRepository;
    private final PlantInfoRepository plantInfoRepository;


    public PlantResponseDto createPlant(PlantRequestDto plantRequestDto) {
        System.out.println(plantRequestDto.getPlantName());
        Plant plant = new Plant(plantRequestDto.getPlantName());
        Plant responsePlant = plantRepository.save(plant);

        PlantResponseDto plantResponseDto = new PlantResponseDto(responsePlant.getId(), responsePlant.getPlantName());
        return plantResponseDto;
    }


}
