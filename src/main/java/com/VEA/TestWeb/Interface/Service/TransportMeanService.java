package com.VEA.TestWeb.Interface.Service;

import com.VEA.TestWeb.Model.Train;
import com.VEA.TestWeb.Model.TransportMean;
import com.VEA.TestWeb.ViewModel.Train.TrainDetailViewModel;
import com.VEA.TestWeb.ViewModel.Train.TrainGridViewModel;
import com.VEA.TestWeb.ViewModel.TransportMean.TransportMeanDetailViewModel;
import com.VEA.TestWeb.ViewModel.TransportMean.TransportMeanGridViewModel;
import org.springframework.boot.rsocket.server.RSocketServer;

import java.util.List;

public interface TransportMeanService extends SavableService<TransportMean, TransportMeanDetailViewModel>{
    public List<TransportMeanGridViewModel> getDataForGrid();
    public TransportMeanDetailViewModel getDetail(int idTrain, int id) throws Exception;
    public void delete(int id) throws Exception;
}
