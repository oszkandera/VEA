package com.VEA.TestWeb.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "[TransportMean]")
public class TransportMean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int id;

    @ManyToOne
    @JoinColumn(name="IdVehicle", nullable=false)
    public Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name="IdCargo", nullable=true)
    public Cargo cargo;

    @ManyToOne
    @JoinColumn(name="IdTrain", nullable=true)
    public Train train;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
