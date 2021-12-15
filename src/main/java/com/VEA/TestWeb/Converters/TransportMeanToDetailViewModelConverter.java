package com.VEA.TestWeb.Converters;

import com.VEA.TestWeb.Model.Cargo;
import com.VEA.TestWeb.Model.Train;
import com.VEA.TestWeb.Model.TransportMean;
import com.VEA.TestWeb.Model.Vehicle;
import com.VEA.TestWeb.ViewModel.TransportMean.TransportMeanDetailViewModel;
import org.springframework.core.convert.converter.Converter;

public class TransportMeanToDetailViewModelConverter implements Converter<TransportMean, TransportMeanDetailViewModel> {

    @Override
    public TransportMeanDetailViewModel convert(TransportMean transportMean) {
        Train train = transportMean.getTrain();
        Cargo cargo = transportMean.getCargo();
        Vehicle vehicle = transportMean.getVehicle();

        return new TransportMeanDetailViewModel(transportMean.getId(),
                train.getId(),
                vehicle.getId(),
                cargo.getId(),
                cargo.getContainer().getId(),
                cargo.getMaterial().getId(),
                cargo.getAmount());
        }
    }
