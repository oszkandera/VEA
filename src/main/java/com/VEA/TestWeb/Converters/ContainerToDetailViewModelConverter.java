package com.VEA.TestWeb.Converters;

import com.VEA.TestWeb.Model.*;
import com.VEA.TestWeb.ViewModel.Container.ContainerDetailViewModel;
import com.VEA.TestWeb.ViewModel.TransportMean.TransportMeanDetailViewModel;
import org.springframework.core.convert.converter.Converter;

public class ContainerToDetailViewModelConverter implements Converter<Container, ContainerDetailViewModel> {

    @Override
    public ContainerDetailViewModel convert(Container container) {
        return new ContainerDetailViewModel(
                container.getId(),
                container.getCode(),
                container.getNote(),
                container.getWidth(),
                container.getHeight(),
                container.getLength());
    }
}
