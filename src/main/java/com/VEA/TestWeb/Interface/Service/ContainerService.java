package com.VEA.TestWeb.Interface.Service;

import com.VEA.TestWeb.Model.Container;
import com.VEA.TestWeb.ViewModel.Container.ContainerDetailViewModel;
import com.VEA.TestWeb.ViewModel.Container.ContainerGridViewModel;
import com.VEA.TestWeb.ViewModel.DropDownListViewModel;

import java.util.List;

public interface ContainerService extends SavableService<Container, ContainerDetailViewModel>{
    public List<ContainerGridViewModel> getDataForGrid();
    public ContainerDetailViewModel getDataForDetail(int id);
    public void delete(int id) throws Exception;
    public List<DropDownListViewModel> getContainerDropDownList();
    public Container findContainer(int id);
}
