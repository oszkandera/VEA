package com.VEA.TestWeb.Service;

import com.VEA.TestWeb.Enums.VehicleType;
import com.VEA.TestWeb.Model.FreightVehicle;
import com.VEA.TestWeb.Model.PersonalVehicle;
import com.VEA.TestWeb.Model.TowingVehicle;
import com.VEA.TestWeb.Model.Vehicle;
import com.VEA.TestWeb.Repository.VehicleRepository;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleDetailViewModel;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleGridViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements com.VEA.TestWeb.Interface.Service.VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;
    
    @Override
    public List<VehicleGridViewModel> getDataForGrid() {
        List<Vehicle> data = vehicleRepository.findAll();

        List<VehicleGridViewModel> viewModelData = new LinkedList<VehicleGridViewModel>();

        for (Vehicle vehicle: data) {
            viewModelData.add(new VehicleGridViewModel(vehicle.id, vehicle.getName(), vehicle.getCode(), vehicle.getVehicleType()));
        }
        
        return viewModelData;
    }

    public VehicleDetailViewModel getDataForDetail(int id){
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        if(vehicle.isEmpty()){
            return new VehicleDetailViewModel();
        }

        Vehicle vehicleInstance = vehicle.get();
        VehicleDetailViewModel viewModelData = vehicleInstance.toVehicleDetailViewModel();

        return viewModelData;
    }

    public Vehicle saveVehicle(VehicleDetailViewModel vehicleDetailViewModel) throws Exception{
        int vehicleId = vehicleDetailViewModel.getId();

        Vehicle vehicle;
        if(vehicleId == 0){
            VehicleType selectedVehicleType = vehicleDetailViewModel.getVehicleType();
            switch (selectedVehicleType){
                case Towing:
                    vehicle = new TowingVehicle();
                    break;
                case Freight:
                    vehicle = new FreightVehicle();
                    break;
                case Personal:
                    vehicle = new PersonalVehicle();
                    break;
                default:
                    throw new Exception("unknown vehicle type");
            }
        }
        else{
            vehicle = findVehicle(vehicleId);

            if(vehicle == null){
                throw new Exception("Vehicle not found");
            }
        }

        vehicle.mapFromVehicleDetailViewModel(vehicleDetailViewModel);
        vehicleRepository.save(vehicle);

        return vehicle;
    }

    public void delete(int id) throws Exception{
        Vehicle vehicle = findVehicle(id);

        if(vehicle == null){
            throw new Exception("vehicle not found");
        }

        vehicleRepository.delete(vehicle);
    }

    private Vehicle findVehicle(int id){
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        if(vehicle.isEmpty()){
            return null;
        }

        return vehicle.get();
    }
}
