package com.VEA.TestWeb.ViewModel.Train;

import com.VEA.TestWeb.ViewModel.TransportMean.TransportMeanGridViewModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

public class TrainDetailViewModel {

    public int id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public LocalDate dateFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public LocalDate dateTo;

    public Set<TransportMeanGridViewModel> transportMeans;

    public TrainDetailViewModel() {}

    public TrainDetailViewModel(int id, LocalDate dateFrom, LocalDate dateTo) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
    public TrainDetailViewModel(int id, LocalDate dateFrom, LocalDate dateTo, Set<TransportMeanGridViewModel> transportMeans) {
        this(id, dateFrom, dateTo);
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

    public Set<TransportMeanGridViewModel> getTransportMeans() {
        return transportMeans;
    }

    public void setTransportMeans(Set<TransportMeanGridViewModel> transportMeans) {
        this.transportMeans = transportMeans;
    }
}
