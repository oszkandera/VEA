package com.VEA.TestWeb;

import com.VEA.TestWeb.Dto.CargoCreateDto;
import com.VEA.TestWeb.Dto.CargoDto;
import com.VEA.TestWeb.Interface.Service.CargoService;
import com.VEA.TestWeb.Interface.Service.MaterialService;
import com.VEA.TestWeb.Model.Cargo;
import com.VEA.TestWeb.Model.Material;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CargoRestController {

    @Autowired
    CargoService cargoService;
    @Autowired
    MaterialService materialService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/cargo/getAll")
    @ResponseBody
    public ResponseEntity<List<CargoDto>> getAll() {

        List<CargoDto> data = cargoService.getAll().stream().map(post -> modelMapper.map(post, CargoDto.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(data);
    }

    @PostMapping("/cargo/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CargoDto add(@RequestBody CargoCreateDto cargoCreateDto){
        Cargo cargo = modelMapper.map(cargoCreateDto, Cargo.class);
        Material material = materialService.findMaterialByCode(cargoCreateDto.materialCode);
        return null;
        //return ResponseEntity.ok(data);
    }
}