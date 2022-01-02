package com.VEA.TestWeb.Interface.Service;

import com.VEA.TestWeb.Model.Material;
import com.VEA.TestWeb.Model.Vehicle;
import com.VEA.TestWeb.ViewModel.DropDownListViewModel;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleDetailViewModel;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleGridViewModel;

import java.util.List;

public interface MaterialService {
    public List<DropDownListViewModel> getMaterialDropDownList();
    public Material findMaterial(int id);
    public Material findMaterialByCode(String code);
}
