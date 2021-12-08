package com.VEA.TestWeb.Model;

import com.VEA.TestWeb.Enums.VehicleType;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleDetailViewModel;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class TowingVehicle extends Vehicle {

    @Column(name = "[BreakingWeight]")
    public double breakingWeight;

    public TowingVehicle() { }

    public TowingVehicle(int id, String code, String note, String name, int numberOfCorrection, int series, double breakingWeight) {
        super(id, code, note, name, numberOfCorrection, series);

        this.setBreakingWeight(breakingWeight);
    }

    public double getBreakingWeight() {
        return breakingWeight;
    }

    public void setBreakingWeight(double breakingWeight) {
        this.breakingWeight = breakingWeight;
    }

    @Override
    public VehicleType getVehicleType(){
        return VehicleType.Towing;
    }

    @Override
    public VehicleDetailViewModel toVehicleDetailViewModel(){
        VehicleDetailViewModel viewModelData = super.toVehicleDetailViewModel();

        viewModelData.setBreakingWeight(this.getBreakingWeight());

        return viewModelData;
    }

    @Override
    public void mapFromVehicleDetailViewModel(VehicleDetailViewModel vehicleDetailViewModel){
        super.mapFromVehicleDetailViewModel(vehicleDetailViewModel);

        this.setBreakingWeight(vehicleDetailViewModel.getBreakingWeight());
    }
}
