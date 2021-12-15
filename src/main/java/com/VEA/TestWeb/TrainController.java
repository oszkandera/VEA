package com.VEA.TestWeb;

import com.VEA.TestWeb.Interface.Service.TrainService;
import com.VEA.TestWeb.Model.Train;
import com.VEA.TestWeb.ViewModel.Train.TrainDetailViewModel;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleDetailViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainController {

    @Autowired
    TrainService trainService;

    @GetMapping("/train")
    public ModelAndView trains()
    {
        ModelAndView mav = new ModelAndView("train");
        mav.addObject("trains", trainService.getDataForGrid());
        return mav;
    }

    @GetMapping("/train/detail")
    public ModelAndView detail(int id)
    {
        ModelAndView mav = new ModelAndView("trainDetail");
        try{
            mav.addObject("train", trainService.getDetail(id));
        }
        catch (Exception e){
            //TODO
        }
        return mav;
    }

    @PostMapping("/train/save")
    public String save(TrainDetailViewModel trainDetailViewModel)
    {
        try{
            Train train = trainService.save(trainDetailViewModel);
            return "redirect:/train/detail?id=" + train.getId();
        }
        catch (Exception e){
            //TODO
            return "redirect:/train/";
        }
    }
    @GetMapping("train/delete")
    public String delete(int id){
        try
        {
            trainService.delete(id);
            return "redirect:/train/";
        }
        catch (Exception e){
            //TODO
            return "redirect:/train/";
        }
    }

}