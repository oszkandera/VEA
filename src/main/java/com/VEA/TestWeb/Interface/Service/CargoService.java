package com.VEA.TestWeb.Interface.Service;

import com.VEA.TestWeb.Model.Cargo;

import java.util.List;

public interface CargoService extends SavableService<Cargo, Cargo>{
    public Cargo createCargo(int idContainer, int idMaterial, double amount) throws Exception;
    public List<Cargo> getAll();
}
