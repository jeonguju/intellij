package com.datasite.project.controller;

import com.datasite.project.dto.PlantRequestDto;
import com.datasite.project.dto.PlantResponseDto;
import com.datasite.project.service.PlantInfoService;
import com.datasite.project.service.PlantService;
import com.datasite.project.dto.PlantInfoRequestDto;
import com.datasite.project.dto.PlantInfoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/plant")
public class PlantController {
    private final PlantService plantService;
    private final PlantInfoService plantInfoService;


    @PostMapping("/Info")
    @ResponseBody
    public PlantInfoResponseDto createPlantInfo(@RequestBody PlantInfoRequestDto plantInfoRequestDto){
        PlantInfoResponseDto plantInfoResponseDto = plantInfoService.createPlantInfo(plantInfoRequestDto);
        return plantInfoResponseDto;
    }

    @PostMapping
    @ResponseBody // 먼저 plant를 만들고 나서 plant에 대한 정보인 plantInfo를 생성한다.
    public PlantResponseDto createPlant(@RequestBody PlantRequestDto plantRequestDto){
        PlantResponseDto plantResponseDto = plantService.createPlant(plantRequestDto);
        return plantResponseDto;
    }

    @GetMapping
    @ResponseBody
    public List<PlantInfoResponseDto> getPlantInfoList(){
        List<PlantInfoResponseDto> plantInfoResponseDtoList = plantInfoService.getPlantInfoList();
        return plantInfoResponseDtoList;
    }

/*    @GetMapping("/{plantDate}")
    @ResponseBody
    public List<PlantInfoResponseDto> getPlantInfoDateList(){
        List<PlantInfoResponseDto> plantInfoResponseDtoList = plantInfoService.getPlantInfoDateList();
        return plantInfoResponseDtoList;
    }*/

    @GetMapping("/{plantId}")
    @ResponseBody
    public PlantInfoResponseDto getPlantInfo(@PathVariable Long plantId){
        PlantInfoResponseDto plantInfoResponseDto = plantInfoService.getPlantInfo(plantId);
        return plantInfoResponseDto;
    }

    @PutMapping("/{plantId}")
    @ResponseBody
    public PlantInfoResponseDto updatePlant(@PathVariable Long plantId, @RequestBody PlantInfoRequestDto plantInfoRequestDto){
        PlantInfoResponseDto plantInfoResponseDto = plantInfoService.updatePlantInfo(plantId, plantInfoRequestDto);
        return plantInfoResponseDto;
    }

    @DeleteMapping("/{plantId}")
    @ResponseBody
    public boolean deletePlant(@PathVariable Long plantId){
        boolean check = plantInfoService.deletePlantInfo(plantId);
        return check;
    }

}

