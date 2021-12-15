package com.VEA.TestWeb.Interface.Service;

import com.VEA.TestWeb.Model.Vehicle;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleDetailViewModel;
import com.VEA.TestWeb.ViewModel.DropDownListViewModel;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleGridViewModel;

import java.util.List;

public interface VehicleService extends SavableService<Vehicle, VehicleDetailViewModel> {
    public List<VehicleGridViewModel> getDataForGrid();
    public VehicleDetailViewModel getDataForDetail(int id);
    public void delete(int id) throws Exception;
    public List<DropDownListViewModel> getVehicleDropDownList();
    public Vehicle findVehicle(int id);
}
