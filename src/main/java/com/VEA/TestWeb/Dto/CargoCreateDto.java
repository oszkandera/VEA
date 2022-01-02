package com.VEA.TestWeb.Dto;


public class CargoCreateDto {
    public double amount;
    public String materialCode;
    public ContainerDto container;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public ContainerDto getContainer() {
        return container;
    }

    public void setContainer(ContainerDto container) {
        this.container = container;
    }
}
