package com.VEA.TestWeb.Service;

import com.VEA.TestWeb.Interface.DAO.ContainerDAO;
import com.VEA.TestWeb.Model.*;
import com.VEA.TestWeb.Repository.CargoRepository;
import com.VEA.TestWeb.Repository.ContainerRepository;
import com.VEA.TestWeb.Repository.TransportMeanRepository;
import com.VEA.TestWeb.ViewModel.Container.ContainerDetailViewModel;
import com.VEA.TestWeb.ViewModel.Container.ContainerGridViewModel;
import com.VEA.TestWeb.ViewModel.DropDownListViewModel;
import com.VEA.TestWeb.ViewModel.TransportMean.TransportMeanDetailViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService implements com.VEA.TestWeb.Interface.Service.CargoService {

    @Autowired
    CargoRepository cargoRepository;
    @Autowired
    ContainerService containerService;
    @Autowired
    MaterialService materialService;

    @Override
    public Cargo createCargo(int idContainer, int idMaterial, double amount) throws Exception {

        Container container = containerService.findContainer(idContainer);
        Material material = materialService.findMaterial(idMaterial);

        Cargo cargo = new Cargo(amount, material, container);

        return cargo;
    }

    @Override
    public Cargo save(Cargo cargo){
        cargoRepository.save(cargo);

        return cargo;
    }

    public List<Cargo> getAll(){
        List<Cargo> data = cargoRepository.findAll();

        return data;
    }
}
