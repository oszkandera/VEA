package com.VEA.TestWeb.ViewModel.Vehicle;

import com.VEA.TestWeb.Enums.VehicleType;
import com.VEA.TestWeb.Model.FreightVehicle;
import com.VEA.TestWeb.Model.Vehicle;

public class VehicleDetailViewModel {
    public int id;
    public String name;
    public String code;
    public int numberOfCorrection;
    public int series;
    public VehicleType vehicleType;
    public String note;
    public double loadCapacity;
    public double breakingWeight;
    public int sittingCapacity;
    public int standingCapacity;

    public VehicleDetailViewModel() { }

    public VehicleDetailViewModel(int id, String name, String code, int numberOfCorrection, int series, String note, VehicleType vehicleType) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.vehicleType = vehicleType;
        this.numberOfCorrection = numberOfCorrection;
        this.series = series;
        this.note = note;
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

    public int getNumberOfCorrection() {
        return numberOfCorrection;
    }

    public void setNumberOfCorrection(int numberOfCorrection) {
        this.numberOfCorrection = numberOfCorrection;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public double getBreakingWeight() {
        return breakingWeight;
    }

    public void setBreakingWeight(double breakingWeight) {
        this.breakingWeight = breakingWeight;
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
}
