package com.VEA.TestWeb.Interface.Service;

import com.VEA.TestWeb.Model.Vehicle;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleDetailViewModel;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleGridViewModel;

import java.util.List;

public interface VehicleService {
    public List<VehicleGridViewModel> getDataForGrid();
    public VehicleDetailViewModel getDataForDetail(int id);
    public Vehicle saveVehicle(VehicleDetailViewModel vehicleDetailViewModel) throws Exception;
    public void delete(int id) throws Exception;
}
