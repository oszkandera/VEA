package com.VEA.TestWeb;

import com.VEA.TestWeb.Interface.Service.ContainerService;
import com.VEA.TestWeb.ViewModel.Container.ContainerDetailViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContainerController {

    @Autowired
    ContainerService containerService;

    @GetMapping("/container")
    public ModelAndView containers()
    {
        ModelAndView mav = new ModelAndView("containers");
        mav.addObject("containers", containerService.getDataForGrid());
        return mav;
    }

    @GetMapping("/container/detail")
    public ModelAndView detail(int id) throws Exception
    {
        ModelAndView mav = new ModelAndView("containerDetail");
        mav.addObject("container", containerService.getDataForDetail(id));
        return mav;
    }

    @PostMapping("container/detail")
    public String detailSubmit(ContainerDetailViewModel containerDetailViewModel){
        try
        {
            var container = containerService.saveContainer(containerDetailViewModel);
            return "redirect:/container/detail?id=" + container.getId();

        }
        catch (Exception e){
            return "redirect:/container/";
        }
    }

    @GetMapping("container/delete")
    public String delete(int id){
        try
        {
            containerService.delete(id);
            return "redirect:/container/";
        }
        catch (Exception e){
            return "redirect:/container/";
        }
    }
}