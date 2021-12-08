package com.VEA.TestWeb.Model;

import javax.persistence.*;
import java.time.LocalDate;
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
}
