package com.VEA.TestWeb.Model;

import com.VEA.TestWeb.Enums.VehicleType;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleDetailViewModel;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class PersonalVehicle extends Vehicle {

    @Column(name = "[SittingCapacity]")
    public int sittingCapacity;

    @Column(name = "[StandingCapacity]")
    public int standingCapacity;

    public PersonalVehicle(){}

    public PersonalVehicle(int id, String code, String note, String name, int numberOfCorrection, int series, int sittingCapacity, int standingCapacity) {
        super(id, code, note, name, numberOfCorrection, series);
        this.setSittingCapacity(sittingCapacity);
        this.setStandingCapacity(standingCapacity);
    }

    public int getSittingCapacity() {
        return sittingCapacity;
    }

    public void setSittingCapacity(int sittingCapacity) {
        this.sittingCapacity = sittingCapacity;
    }

    public int getStandingCapacity() {
        return standingCapacity;
    }

    public void setStandingCapacity(int standingCapacity) {
        this.standingCapacity = standingCapacity;
    }

    @Override
    public VehicleType getVehicleType(){
        return VehicleType.Personal;
    }

    @Override
    public VehicleDetailViewModel toVehicleDetailViewModel(){
        VehicleDetailViewModel viewModelData = super.toVehicleDetailViewModel();

        viewModelData.setStandingCapacity(this.getStandingCapacity());
        viewModelData.setSittingCapacity(this.getSittingCapacity());

        return viewModelData;
    }

    @Override
    public void mapFromVehicleDetailViewModel(VehicleDetailViewModel vehicleDetailViewModel){
        super.mapFromVehicleDetailViewModel(vehicleDetailViewModel);

        this.setStandingCapacity(vehicleDetailViewModel.getStandingCapacity());
        this.setSittingCapacity(vehicleDetailViewModel.getSittingCapacity());
    }
}
