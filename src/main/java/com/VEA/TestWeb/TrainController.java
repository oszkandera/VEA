package com.VEA.TestWeb;

import com.VEA.TestWeb.Interface.Service.TrainService;
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
        mav.addObject("train", trainService.getDetail(id));
        return mav;
    }

    @PostMapping("/train/save")
    public ModelAndView save(TrainDetailViewModel trainDetailViewModel)
    {
        //TODO: Doresit ukladani vlaku: vlak je v prvni fazi nutne ulozit. Po ulozeni se zpristupni grid na nasazeni prostredku na vlak

        ModelAndView mav = new ModelAndView("trainDetail");
        //mav.addObject("train", trainService.getDetail(id));
        return mav;
    }
}