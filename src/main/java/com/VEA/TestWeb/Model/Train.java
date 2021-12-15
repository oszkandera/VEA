package com.VEA.TestWeb.Model;

import com.VEA.TestWeb.Enums.VehicleType;
import com.VEA.TestWeb.ViewModel.Train.TrainDetailViewModel;
import com.VEA.TestWeb.ViewModel.TransportMean.TransportMeanGridViewModel;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "[Train]")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int id;

    @Column(name = "DateFrom")
    public LocalDate dateFrom;

    @Column(name = "DateTo")
    public LocalDate dateTo;

    @OneToMany(mappedBy="train")
    public Set<TransportMean> transportMeans;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Set<TransportMean> getTransportMeans() {
        return transportMeans;
    }

    public void setTransportMeans(Set<TransportMean> transportMeans) {
        this.transportMeans = transportMeans;
    }

    public int getTransportMeanCount(){
        if(this.transportMeans == null){
            return 0;
        }

        return ((int) this.transportMeans.stream().count());
    }

    public TrainDetailViewModel toTrainDetailViewModel(){
        Set<TransportMeanGridViewModel> transportMeanGridViewModelList = new HashSet<TransportMeanGridViewModel>();

        for (TransportMean transportMean : this.getTransportMeans()) {
            VehicleType vehicleType = transportMean.getVehicle().getVehicleType();
            String material = "";
            Double amount = null;
            if(transportMean.getCargo() != null){
                material = transportMean.getCargo().getMaterial().getName();
                amount = transportMean.getCargo().getAmount();
            }

            transportMeanGridViewModelList.add(new TransportMeanGridViewModel(transportMean.id, vehicleType, material, amount));
        }

        return new TrainDetailViewModel(id, dateFrom, dateTo, transportMeanGridViewModelList);
    }

    public void mapFromTrainDetailViewModel(TrainDetailViewModel trainDetailViewModel){
        this.dateFrom = trainDetailViewModel.dateFrom;
        this.dateTo = trainDetailViewModel.dateTo;
    }
}
