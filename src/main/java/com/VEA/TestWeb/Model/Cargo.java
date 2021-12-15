package com.VEA.TestWeb.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "[Cargo]")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int id;

    @Column(name = "Amount")
    public double amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IdMaterial", nullable = false)
    public Material material;

    @ManyToOne()
    @JoinColumn(name = "IdContainer", nullable = false)
    public Container container;

    public Cargo() {
    }

    public Cargo(double amount, Material material, Container container) {
        this.amount = amount;
        this.material = material;
        this.container = container;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }
}
