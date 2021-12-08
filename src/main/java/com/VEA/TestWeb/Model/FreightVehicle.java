package com.VEA.TestWeb.Model;

import com.VEA.TestWeb.Enums.VehicleType;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleDetailViewModel;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@DiscriminatorValue("2")
public class FreightVehicle extends Vehicle {

    @Column(name = "[LoadCapacity]")
    public double loadCapacity;

    public FreightVehicle() { }

    public FreightVehicle(int id, String code, String note, String name, int numberOfCorrection, int series, double loadCapacity) {
        super(id, code, note, name, numberOfCorrection, series);
        this.setLoadCapacity(loadCapacity);
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }


    @Override
    public VehicleType getVehicleType(){
        return VehicleType.Freight;
    }

    @Override
    public VehicleDetailViewModel toVehicleDetailViewModel(){
        VehicleDetailViewModel viewModelData = super.toVehicleDetailViewModel();

        viewModelData.setLoadCapacity(this.getLoadCapacity());

        return viewModelData;
    }

    @Override
    public void mapFromVehicleDetailViewModel(VehicleDetailViewModel vehicleDetailViewModel){
        super.mapFromVehicleDetailViewModel(vehicleDetailViewModel);

        this.setLoadCapacity(vehicleDetailViewModel.getLoadCapacity());
    }
}
