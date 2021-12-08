package com.VEA.TestWeb.Interface.Service;

import com.VEA.TestWeb.Model.Container;
import com.VEA.TestWeb.ViewModel.Container.ContainerDetailViewModel;
import com.VEA.TestWeb.ViewModel.Container.ContainerGridViewModel;

import java.util.List;

public interface ContainerService {
    public List<ContainerGridViewModel> getDataForGrid();
    public ContainerDetailViewModel getDataForDetail(int id);
    public Container saveContainer(ContainerDetailViewModel containerDetailViewModel) throws Exception;
    public void delete(int id) throws Exception;
}
