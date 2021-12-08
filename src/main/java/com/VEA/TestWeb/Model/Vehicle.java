package com.VEA.TestWeb.Model;

import com.VEA.TestWeb.Enums.VehicleType;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleDetailViewModel;

import javax.persistence.*;

@Entity
@Table(name = "[Vehicle]")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="VehicleType", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int id;

    @Column(name = "[Code]")
    public String code; //TODO: Converter, which will be converting code to formatted code???

    @Column(name = "[Note]")
    public String note;

    @Column(name = "[Name]")
    public String name;

    @Column(name = "[NumberOfCorrection]")
    public int numberOfCorrection;

    @Column(name = "[Series]")
    public int series;

    public Vehicle() { }

    public Vehicle(int id, String code, String note, String name, int numberOfCorrection, int series) {
        this.id = id;
        this.code = code;
        this.note = note;
        this.name = name;
        this.numberOfCorrection = numberOfCorrection;
        this.series = series;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public abstract VehicleType getVehicleType();

    public VehicleDetailViewModel toVehicleDetailViewModel(){
        VehicleDetailViewModel viewModelData = new VehicleDetailViewModel(this.getId(),
                this.getName(),
                this.getCode(),
                this.getNumberOfCorrection(),
                this.getSeries(),
                this.getNote(),
                this.getVehicleType());

        return viewModelData;
    }

    public void mapFromVehicleDetailViewModel(VehicleDetailViewModel vehicleDetailViewModel){
        this.setCode(vehicleDetailViewModel.code);
        this.setName(vehicleDetailViewModel.name);
        this.setNumberOfCorrection(vehicleDetailViewModel.numberOfCorrection);
        this.setSeries(vehicleDetailViewModel.series);
        this.setNote(vehicleDetailViewModel.note);
    }
}
