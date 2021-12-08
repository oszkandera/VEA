package com.VEA.TestWeb.ViewModel.Train;

import com.VEA.TestWeb.Model.TransportMean;

import java.time.LocalDate;
import java.util.Set;

public class TrainDetailViewModel {

    public int id;
    public LocalDate dateFrom;
    public LocalDate dateTo;

    public Set<TransportMean> transportMeans;

    public TrainDetailViewModel() {}

    public TrainDetailViewModel(int id, LocalDate dateFrom, LocalDate dateTo, Set<TransportMean> transportMeans) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.transportMeans = transportMeans;
    }

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
}
