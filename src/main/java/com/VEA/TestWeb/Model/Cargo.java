package com.VEA.TestWeb.Model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "[Cargo]")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int id;

    @Column(name = "Amount")
    public LocalDateTime amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IdMaterial", nullable = false)
    public Material material;

    @ManyToMany(mappedBy = "cargo")
    public Set<Container> containers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getAmount() {
        return amount;
    }

    public void setAmount(LocalDateTime amount) {
        this.amount = amount;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Set<Container> getContainers() {
        return containers;
    }

    public void setContainers(Set<Container> containers) {
        this.containers = containers;
    }
}
