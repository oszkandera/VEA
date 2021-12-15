package com.VEA.TestWeb.ViewModel.TransportMean;

public class TransportMeanDetailViewModel {
    public int id;
    public int idTrain;
    public int idVehicle;
    public int idCargo;
    public int idContainer;
    public int idMaterial;
    public double amount;

    public TransportMeanDetailViewModel() {
    }

    public TransportMeanDetailViewModel(int id, int idTrain, int idVehicle, int idCargo, int idContainer, int idMaterial, double amount) {
        this();
        this.id = id;
        this.idVehicle = idVehicle;
        this.idCargo = idCargo;
        this.idTrain = idTrain;
        this.idContainer = idContainer;
        this.idMaterial = idMaterial;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(int idTrain) {
        this.idTrain = idTrain;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public int getIdContainer() {
        return idContainer;
    }

    public void setIdContainer(int idContainer) {
        this.idContainer = idContainer;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
