package com.VEA.TestWeb.Service;

import com.VEA.TestWeb.Model.Train;
import com.VEA.TestWeb.Repository.TrainRepository;
import com.VEA.TestWeb.ViewModel.Train.TrainDetailViewModel;
import com.VEA.TestWeb.ViewModel.Train.TrainGridViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TrainService implements com.VEA.TestWeb.Interface.Service.TrainService {

    @Autowired
    TrainRepository trainRepository;


    @Override
    public List<TrainGridViewModel> getDataForGrid() {
        List<Train> data = trainRepository.findAll();

        List<TrainGridViewModel> viewModelData = new LinkedList<TrainGridViewModel>();

        for (Train train : data) {

            viewModelData.add(new TrainGridViewModel(train.getId(), train.getDateFrom(), train.getDateTo(), train.getTransportMeanCount()));
        }

        return viewModelData;
    }

    @Override
    public TrainDetailViewModel getDetail(int id) {
        if(id == 0){
            return new TrainDetailViewModel();
        }

        //TODO
        return null;
    }
}
