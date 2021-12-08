package com.VEA.TestWeb.ViewModel.Container;

public class ContainerGridViewModel {

    public ContainerGridViewModel(int id, String code, String note) {
        this.id = id;
        this.code = code;
        this.note = note;
    }
    public int id;
    public String code;
    public String note;

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
}
