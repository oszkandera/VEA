package com.VEA.TestWeb.Interface.Service;

import com.VEA.TestWeb.Model.Train;
import com.VEA.TestWeb.ViewModel.Train.TrainDetailViewModel;
import com.VEA.TestWeb.ViewModel.Train.TrainGridViewModel;

import java.util.List;

public interface TrainService extends SavableService<Train, TrainDetailViewModel> {
    public List<TrainGridViewModel> getDataForGrid();
    public TrainDetailViewModel getDetail(int id) throws Exception;
    public Train findTrain(int id);
    public void delete(int id) throws Exception;
}
