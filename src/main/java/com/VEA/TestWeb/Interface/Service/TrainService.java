package com.VEA.TestWeb.Interface.Service;

import com.VEA.TestWeb.ViewModel.Train.TrainDetailViewModel;
import com.VEA.TestWeb.ViewModel.Train.TrainGridViewModel;

import java.util.List;

public interface TrainService {
    public List<TrainGridViewModel> getDataForGrid();
    public TrainDetailViewModel getDetail(int id);
}
