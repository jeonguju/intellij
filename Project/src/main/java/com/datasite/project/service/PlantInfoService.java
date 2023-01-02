package com.datasite.project.service;

import com.datasite.project.dto.PlantInfoRequestDto;
import com.datasite.project.dto.PlantInfoResponseDto;
import com.datasite.project.dto.PlantResponseDto;
import com.datasite.project.entity.Plant;
import com.datasite.project.entity.PlantInfo;
import com.datasite.project.repository.PlantInfoRepository;
import com.datasite.project.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantInfoService {
    private final PlantRepository plantRepository;
    private final PlantInfoRepository plantInfoRepository;

    public List<PlantInfoResponseDto> getPlantInfoList() {
        List<PlantInfoResponseDto> plantInfoResponseDtoList = new ArrayList<>();
        List<PlantInfo> plantInfoList = plantInfoRepository.findAll();
        PlantInfoResponseDto plantInfoResponseDto;
        for(PlantInfo plantinfo : plantInfoList){
            Plant plant = plantRepository.findById(plantinfo.getPlant().getId()).get();
            plantInfoResponseDto = new PlantInfoResponseDto(
                    plantinfo.getId(),
                    plant.getPlantName(),
                    plantinfo.getSensormac(),
                    plantinfo.getTemperature(),
                    plantinfo.getIndoorHumidity(),
                    plantinfo.getSoilHumidity(),
                    plantinfo.getIlluminance(),
                    plantinfo.getCreatedDate(),
                    plantinfo.getCreatedTime(),
                    plantinfo.getCreatedAt());
            plantInfoResponseDtoList.add(plantInfoResponseDto);
        }
        return plantInfoResponseDtoList;


    }

    public PlantInfoResponseDto getPlantInfo(long plantInfoId) {
        PlantInfo plantInfo = plantInfoRepository.findById(plantInfoId).orElseThrow(
                ()->new IllegalArgumentException("PlantInfo를 찾지 못했습니다.")
        );
        Plant plant = plantRepository.findById(plantInfo.getPlant().getId()).get();
        PlantInfoResponseDto plantInfoResponseDto = new PlantInfoResponseDto(
                plantInfo.getId(),
                plant.getPlantName(),
                plantInfo.getSensormac(),
                plantInfo.getTemperature(),
                plantInfo.getIndoorHumidity(),
                plantInfo.getSoilHumidity(),
                plantInfo.getIlluminance(),
                plantInfo.getCreatedDate(),
                plantInfo.getCreatedTime(),
                plantInfo.getCreatedAt());
        return plantInfoResponseDto;

    }

    public PlantInfoResponseDto createPlantInfo(PlantInfoRequestDto requestDto) {
        Plant plant = plantRepository.findById(requestDto.getPlantId()).orElseThrow(
                ()-> new IllegalArgumentException("없는 식물 id 입니다.")
        );
        PlantInfo plantInfo = PlantInfo.builder()
                .plant(plant)
                .illuminance(requestDto.getIlluminance())
                .temperature(requestDto.getTemperature())
                .indoorHumidity(requestDto.getIndoorHumidity())
                .sensormac(requestDto.getSensormac())
                .soilHumidity(requestDto.getSoilHumidity())
                .build();
        PlantInfo response = plantInfoRepository.save(plantInfo);
        PlantInfoResponseDto plantInfoResponseDto = new PlantInfoResponseDto(
                response.getId(),
                plant.getPlantName(),
                response.getSensormac(),
                response.getTemperature(),
                response.getIndoorHumidity(),
                response.getSoilHumidity(),
                response.getIlluminance(),
                response.getCreatedDate(),
                response.getCreatedTime(),
                response.getCreatedAt());
        return plantInfoResponseDto;
    }

    public PlantInfoResponseDto updatePlantInfo(Long plantId, PlantInfoRequestDto plantInfoRequestDto){
        PlantInfo plantInfo = plantInfoRepository.findById(plantId).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 데이터입니다.")
        );
        plantInfo.update(
                plantInfoRequestDto.getSensormac(),
                plantInfoRequestDto.getTemperature(),
                plantInfoRequestDto.getIndoorHumidity(),
                plantInfoRequestDto.getSoilHumidity(),
                plantInfoRequestDto.getIlluminance()
        );
        PlantInfo response = plantInfoRepository.save(plantInfo);
        PlantInfoResponseDto plantInfoResponseDto = new PlantInfoResponseDto(
                response.getId(),
                response.getPlant().getPlantName(),
                response.getSensormac(),
                response.getTemperature(),
                response.getIndoorHumidity(),
                response.getSoilHumidity(),
                response.getIlluminance(),
                response.getCreatedDate(),
                response.getCreatedTime(),
                response.getCreatedAt());
        return plantInfoResponseDto;
    }

    public boolean deletePlantInfo(Long plantId){
        PlantInfo plantInfo = plantInfoRepository.findById(plantId).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 데이터입니다.")
        );
        plantInfoRepository.delete(plantInfo);
//        plantInfoRepository.deleteById(plantId);
        return true;
    }

}
