package com.VEA.TestWeb;

import com.VEA.TestWeb.Dto.CargoCreateDto;
import com.VEA.TestWeb.Dto.CargoDto;
import com.VEA.TestWeb.Dto.TransportMeanCreateDto;
import com.VEA.TestWeb.Interface.Service.*;
import com.VEA.TestWeb.Model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TransportMeanRestController {

    @Autowired
    TransportMeanService transportMeanService;

    @PostMapping("/transportMean/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Integer> add(@RequestBody TransportMeanCreateDto transportMeanCreateDto){
        TransportMean transportMean = transportMeanService.save(transportMeanCreateDto);
        return ResponseEntity.ok(transportMean.getId());
    }
}