package com.VEA.TestWeb.Service;

import com.VEA.TestWeb.Model.Container;
import com.VEA.TestWeb.Model.Train;
import com.VEA.TestWeb.Model.TransportMean;
import com.VEA.TestWeb.Repository.TrainRepository;
import com.VEA.TestWeb.ViewModel.Container.ContainerDetailViewModel;
import com.VEA.TestWeb.ViewModel.Train.TrainDetailViewModel;
import com.VEA.TestWeb.ViewModel.Train.TrainGridViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
    public TrainDetailViewModel getDetail(int id) throws Exception {
        if(id == 0){
            return new TrainDetailViewModel();
        }

        Train train = findTrain(id);

        if(train == null){
            throw new Exception("train not found");
        }

        return train.toTrainDetailViewModel();
    }

    @Override
    public Train save(TrainDetailViewModel trainDetailViewModel) throws Exception{
        int id = trainDetailViewModel.getId();

        Train train;
        if(id == 0){
            train = new Train();
        }
        else{
            train = findTrain(id);

            if(train == null){
                throw new Exception("Vehicle not found");
            }
        }

        train.mapFromTrainDetailViewModel(trainDetailViewModel);
        trainRepository.save(train);

        return train;
    }

    public void delete(int id) throws Exception{
        Train train = findTrain(id);

        if(train == null){
            throw new Exception("vehicle not found");
        }

        trainRepository.delete(train);
    }

    public Train findTrain(int id){
        Optional<Train> train = trainRepository.findById(id);

        if(train.isEmpty()){
            return null;
        }

        return train.get();
    }
}
