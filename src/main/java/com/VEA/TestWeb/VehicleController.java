package com.VEA.TestWeb;

import com.VEA.TestWeb.Enums.VehicleType;
import com.VEA.TestWeb.Interface.Service.VehicleService;
import com.VEA.TestWeb.Model.Vehicle;
import com.VEA.TestWeb.ViewModel.Vehicle.VehicleDetailViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/vehicle")
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView("vehicle");
        mav.addObject("vehicles", vehicleService.getDataForGrid());
        return mav;
    }

    @GetMapping("/vehicle/detail")
    public ModelAndView detail(int id) throws Exception
    {
        ModelAndView mav = new ModelAndView("vehicleDetail");
        mav.addObject("vehicle", vehicleService.getDataForDetail(id));
        return mav;
    }

    @PostMapping("vehicle/detail")
    public String detailSubmit(VehicleDetailViewModel vehicleDetailViewModel){
        try
        {
            var vehicle = vehicleService.save(vehicleDetailViewModel);
            return "redirect:/vehicle/detail?id=" + vehicle.getId();

        }
        catch (Exception e){
            return "redirect:/vehicle/";
        }
    }

    @GetMapping("vehicle/delete")
    public String delete(int id){
        try
        {
            vehicleService.delete(id);
            return "redirect:/vehicle/";
        }
        catch (Exception e){
            return "redirect:/vehicle/";
        }
    }

    @GetMapping("vehicle/getVehicleType")
    public @ResponseBody
    VehicleType getVehicleType(int id){
        Vehicle vehicle = vehicleService.findVehicle(id);
        return vehicle.getVehicleType();
    }
}
