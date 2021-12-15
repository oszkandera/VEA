package com.VEA.TestWeb.ViewModel.TransportMean;

import com.VEA.TestWeb.Enums.VehicleType;

public class TransportMeanGridViewModel {
    public int id;
    public VehicleType vehicleType;
    public String material;
    public Double amount;

    public TransportMeanGridViewModel(int id, VehicleType vehicleType, String material, Double amount) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.material = material;
        this.amount = amount;
    }
}
