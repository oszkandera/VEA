package com.VEA.TestWeb.ViewModel.Container;

public class ContainerDetailViewModel {
    public int id;
    public String code;
    public String note;
    public double width;
    public double height;
    public double length;

    public ContainerDetailViewModel(){}

    public ContainerDetailViewModel(int id, String code, String note, double width, double height, double length) {
        this.id = id;
        this.code = code;
        this.note = note;
        this.width = width;
        this.height = height;
        this.length = length;
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
}
