package com.VEA.TestWeb;

import com.VEA.TestWeb.Interface.Service.*;
import com.VEA.TestWeb.Model.Train;
import com.VEA.TestWeb.Model.TransportMean;
import com.VEA.TestWeb.ViewModel.Train.TrainDetailViewModel;
import com.VEA.TestWeb.ViewModel.TransportMean.TransportMeanDetailViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransportMeanController {

    @Autowired
    TransportMeanService transportMeanService;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    ContainerService containerService;
    @Autowired
    MaterialService materialService;

    @GetMapping("/transportMean/detail")
    public ModelAndView detail(int idTrain, int id)
    {
        ModelAndView mav = new ModelAndView("transportMeanDetail");
        try{
            mav.addObject("transportMean", transportMeanService.getDetail(idTrain, id));
            mav.addObject("vehicleDropDownList", vehicleService.getVehicleDropDownList());
            mav.addObject("containerDropDownList", containerService.getContainerDropDownList());
            mav.addObject("materialDropDownList", materialService.getMaterialDropDownList());
        }
        catch (Exception e){
            //TODO
        }
        return mav;
    }

    @PostMapping("/transportMean/save")
    public String save(TransportMeanDetailViewModel transportMeanDetailViewModel)
    {
        try{
            TransportMean transportMean = transportMeanService.save(transportMeanDetailViewModel);
            return "redirect:/train/detail?id=" + transportMean.getTrain().getId();
        }
        catch (Exception e){
            //TODO
            return "redirect:/train/";
        }
    }

    @GetMapping("transportMean/delete")
    public String delete(int idTrain, int id){
        try
        {
            transportMeanService.delete(id);
            return "redirect:/train/detail?id=" + idTrain;
        }
        catch (Exception e){
            //TODO
            return "redirect:/train/";
        }
    }

}