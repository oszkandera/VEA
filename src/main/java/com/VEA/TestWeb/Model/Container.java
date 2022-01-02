package com.VEA.TestWeb.Model;

import com.VEA.TestWeb.ViewModel.Container.ContainerDetailViewModel;
import com.VEA.TestWeb.ViewModel.Container.ContainerGridViewModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "[Container]")
public class Container {
    public Container() { }

    public Container(int id, String code, String note, double width, double height, double length) {
        this.id = id;
        this.code = code;
        this.width = width;
        this.height = height;
        this.length = length;
        this.note = note;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int id;

    @Column(name = "Code")
    public String code;

    @Column(name = "Note")
    public String note;

    @Column(name = "Width")
    public double width;

    @Column(name = "Height")
    public double height;

    @Column(name = "Length")
    public double length;

    @OneToMany(mappedBy="container")
    private Set<Cargo> cargo = new HashSet<>();

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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Set<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(Set<Cargo> cargo) {
        this.cargo = cargo;
    }

    public void mapFromContainerDetailViewModel(ContainerDetailViewModel containerDetailViewModel){
        this.setCode(containerDetailViewModel.getCode());
        this.setNote(containerDetailViewModel.getNote());
        this.setHeight(containerDetailViewModel.getHeight());
        this.setWidth(containerDetailViewModel.getWidth());
        this.setLength(containerDetailViewModel.getLength());
    }
}
