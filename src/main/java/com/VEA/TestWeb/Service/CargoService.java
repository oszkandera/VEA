package com.VEA.TestWeb.Service;

import com.VEA.TestWeb.Model.Container;
import com.VEA.TestWeb.Repository.CargoRepository;
import com.VEA.TestWeb.Repository.ContainerRepository;
import com.VEA.TestWeb.ViewModel.Container.ContainerDetailViewModel;
import com.VEA.TestWeb.ViewModel.Container.ContainerGridViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService implements com.VEA.TestWeb.Interface.Service.CargoService {

    @Autowired
    CargoRepository cargoRepository;


}
