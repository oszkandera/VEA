package com.VEA.TestWeb.Service;

import com.VEA.TestWeb.Dto.TransportMeanCreateDto;
import com.VEA.TestWeb.Enums.VehicleType;
import com.VEA.TestWeb.Model.*;
import com.VEA.TestWeb.Repository.TransportMeanRepository;
import com.VEA.TestWeb.Repository.VehicleRepository;
import com.VEA.TestWeb.ViewModel.Train.TrainDetailViewModel;
import com.VEA.TestWeb.ViewModel.TransportMean.TransportMeanDetailViewModel;
import com.VEA.TestWeb.ViewModel.TransportMean.TransportMeanGridViewModel;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleGridViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TransportMeanService implements com.VEA.TestWeb.Interface.Service.TransportMeanService {

    @Autowired
    TransportMeanRepository transportMeanRepository;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    TrainService trainService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    MaterialService materialService;
    @Autowired
    ContainerService containerService;
    @Autowired
    ConversionService conversionService;
    @Autowired
    CargoService cargoService;

    @Override
    public List<TransportMeanGridViewModel> getDataForGrid() {
        List<TransportMean> data = transportMeanRepository.findAll();

        List<TransportMeanGridViewModel> viewModelData = new LinkedList<TransportMeanGridViewModel>();

        for (TransportMean transportMean: data) {
            VehicleType vehicleType = transportMean.getVehicle().getVehicleType();
            String material = transportMean.getCargo().getMaterial().getName();
            double amount = transportMean.getCargo().getAmount();
            viewModelData.add(new TransportMeanGridViewModel(transportMean.id, vehicleType, material, amount));
        }

        return viewModelData;
    }

    @Override
    public TransportMeanDetailViewModel getDetail(int idTrain, int id) throws Exception {
        if(id == 0){
            TransportMeanDetailViewModel transportMeanDetailViewModel = new TransportMeanDetailViewModel();
            transportMeanDetailViewModel.setIdTrain(idTrain);
            return transportMeanDetailViewModel;
        }

        TransportMean transportMean = findTransportMean(id);

        if(transportMean == null){
            throw new Exception("transportMean not found");
        }

        TransportMeanDetailViewModel transportMeanDetailViewModel = conversionService.convert(transportMean, TransportMeanDetailViewModel.class);
        transportMeanDetailViewModel.setIdTrain(idTrain);
        return transportMeanDetailViewModel;
    }

    @Override
    @Transactional
    public TransportMean save(TransportMeanDetailViewModel transportMeanDetailViewModel) throws Exception {
        int transportMeanId = transportMeanDetailViewModel.getId();

        Vehicle vehicle = vehicleService.findVehicle(transportMeanDetailViewModel.getIdVehicle());
        Train train = trainService.findTrain(transportMeanDetailViewModel.getIdTrain());

        TransportMean transportMean;
        if(transportMeanId == 0){
            transportMean = new TransportMean();
            if(!(vehicle instanceof PersonalVehicle)){
                Cargo cargo = cargoService.createCargo(
                        transportMeanDetailViewModel.getIdContainer(),
                        transportMeanDetailViewModel.getIdMaterial(),
                        transportMeanDetailViewModel.getAmount());

                transportMean.setCargo(cargo);

                cargoService.save(cargo);
            }
        }
        else{
            transportMean = findTransportMean(transportMeanId);
        }
        transportMean.setVehicle(vehicle);
        transportMean.setTrain(train);

        transportMeanRepository.save(transportMean);

        return transportMean;
    }

    @Override
    @Transactional
    public TransportMean save(TransportMeanCreateDto transportMeanCreateDto){
        Cargo cargo = modelMapper.map(transportMeanCreateDto.cargo, Cargo.class);
        Container container = modelMapper.map(transportMeanCreateDto.cargo.container, Container.class);

        Material material = materialService.findMaterialByCode(transportMeanCreateDto.cargo.materialCode);
        Vehicle vehicle = vehicleService.findByCode(transportMeanCreateDto.vehicleCode);
        Train train = trainService.findTrain(transportMeanCreateDto.trainId);

        cargo.setMaterial(material);
        cargo.setContainer(container);

        TransportMean transportMean = new TransportMean();
        transportMean.setCargo(cargo);
        transportMean.setVehicle(vehicle);
        transportMean.setTrain(train);

        containerService.save(container);
        cargoService.save(cargo);
        transportMeanRepository.save(transportMean);

        return  transportMean;
    }

    public void delete(int id) throws Exception{
        TransportMean transportMean = findTransportMean(id);

        if(transportMean == null){
            throw new Exception("vehicle not found");
        }

        transportMeanRepository.delete(transportMean);
    }

    private TransportMean findTransportMean(int id){
        Optional<TransportMean> transportMean = transportMeanRepository.findById(id);

        if(transportMean.isEmpty()){
            return null;
        }

        return transportMean.get();
    }
}
