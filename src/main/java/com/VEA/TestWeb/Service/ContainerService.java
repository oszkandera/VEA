package com.VEA.TestWeb.Service;

import com.VEA.TestWeb.Enums.VehicleType;
import com.VEA.TestWeb.Model.*;
import com.VEA.TestWeb.Repository.ContainerRepository;
import com.VEA.TestWeb.ViewModel.Container.ContainerDetailViewModel;
import com.VEA.TestWeb.ViewModel.Container.ContainerGridViewModel;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleDetailViewModel;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleGridViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ContainerService implements com.VEA.TestWeb.Interface.Service.ContainerService {

    @Autowired
    ContainerRepository containerRepository;

    @Override
    public List<ContainerGridViewModel> getDataForGrid() {
        List<Container> data = containerRepository.findAll();

        List<ContainerGridViewModel> viewModelData = new LinkedList<ContainerGridViewModel>();

        for (Container container: data) {
            viewModelData.add(new ContainerGridViewModel(container.getId(), container.getCode(), container.getNote()));
        }

        return viewModelData;
    }

    @Override
    public ContainerDetailViewModel getDataForDetail(int id) {
        Optional<Container> container = containerRepository.findById(id);

        if(container.isEmpty()){
            return new ContainerDetailViewModel();
        }

        Container containerInstance = container.get();
        ContainerDetailViewModel viewModelData = containerInstance.toContainerDetailViewModel();

        return viewModelData;
    }

    public Container saveContainer(ContainerDetailViewModel containerDetailViewModel) throws Exception{
        int containerId = containerDetailViewModel.getId();

        Container container;
        if(containerId == 0){
            container = new Container();
        }
        else{
            container = findContainer(containerId);

            if(container == null){
                throw new Exception("Vehicle not found");
            }
        }

        container.mapFromContainerDetailViewModel(containerDetailViewModel);
        containerRepository.save(container);

        return container;
    }

    public void delete(int id) throws Exception{
        Container container = findContainer(id);

        if(container == null){
            throw new Exception("container not found");
        }

        containerRepository.delete(container);
    }

    private Container findContainer(int id){
        Optional<Container> container = containerRepository.findById(id);

        if(container.isEmpty()){
            return null;
        }

        return container.get();
    }
}
