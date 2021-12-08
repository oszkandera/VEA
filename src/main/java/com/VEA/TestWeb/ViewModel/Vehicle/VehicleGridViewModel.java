package com.VEA.TestWeb.ViewModel.Vehicle;

import com.VEA.TestWeb.Enums.VehicleType;

public class VehicleGridViewModel {
    public int id;
    public String name;
    public String code;
    public VehicleType vehicleType;

    public VehicleGridViewModel() { }

    public VehicleGridViewModel(int id, String name, String code, VehicleType vehicleType) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.vehicleType = vehicleType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
