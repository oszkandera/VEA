package com.VEA.TestWeb.Service;

import com.VEA.TestWeb.Enums.VehicleType;
import com.VEA.TestWeb.Model.*;
import com.VEA.TestWeb.Repository.MaterialRepository;
import com.VEA.TestWeb.Repository.VehicleRepository;
import com.VEA.TestWeb.ViewModel.DropDownListViewModel;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleDetailViewModel;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleGridViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialService implements com.VEA.TestWeb.Interface.Service.MaterialService {

    @Autowired
    MaterialRepository materialRepository;


    @Override
    public List<DropDownListViewModel> getMaterialDropDownList() {
        List<Material> data = materialRepository.findAll();

        List<DropDownListViewModel> dropDownList = new LinkedList<DropDownListViewModel>();

        for (Material material: data) {
            dropDownList.add(new DropDownListViewModel(material.id, material.getName()));
        }

        return dropDownList;
    }

    public Material findMaterial(int id){
        Optional<Material> material = materialRepository.findById(id);

        if(material.isEmpty()){
            return null;
        }

        return material.get();
    }

    @Override
    public Material findMaterialByCode(String code) {
        Optional<Material> material = materialRepository.findAll().stream().filter(x -> x.code.equals(code)).findFirst();

        if(material.isEmpty()){
            return null;
        }

        return material.get();
    }
}
