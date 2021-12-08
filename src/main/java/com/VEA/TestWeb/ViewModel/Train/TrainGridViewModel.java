package com.VEA.TestWeb.ViewModel.Train;

import java.time.LocalDate;

public class TrainGridViewModel {

    public int Id;
    public LocalDate DateFrom;
    public LocalDate DateTo;
    public int transportMeanCount;

    public TrainGridViewModel(int id, LocalDate dateFrom, LocalDate dateTo, int transportMeanCount) {
        Id = id;
        DateFrom = dateFrom;
        DateTo = dateTo;
        this.transportMeanCount = transportMeanCount;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public LocalDate getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        DateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return DateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        DateTo = dateTo;
    }

    public int getTransportMeanCount() {
        return transportMeanCount;
    }

    public void setTransportMeanCount(int transportMeanCount) {
        this.transportMeanCount = transportMeanCount;
    }
}
