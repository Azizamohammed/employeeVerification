package com.example.online_backend.model;

import com.example.online_backend.repository.EmpoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeAPI {
    @Autowired
    public EmpoRepo empoRepo;

    @GetMapping({"/showEmployee", "/list"})
    public ModelAndView showEmployee(){
        ModelAndView mav = new ModelAndView("list-employee");
        List<Employee> customerTableList = empoRepo.findAll();
        mav.addObject("Employee",customerTableList);
        return  mav;
    }


    @GetMapping("/add-Employee")
    public  ModelAndView addEmployee(){
        ModelAndView mav = new ModelAndView("add-employee");
        Employee employee = new Employee();
        mav.addObject("employ",employee);
        return  mav;
    }
    @GetMapping({"/logout","/"})
    public  ModelAndView logout(){
        ModelAndView arafa = new ModelAndView("login");
        Employee employee = new Employee();
        arafa.addObject("login",employee);
        return arafa;
    }


    @GetMapping("/updateEmployee")
    public ModelAndView updateEmployee(@RequestParam int id){
        ModelAndView aziza = new ModelAndView("update-emp");
        Employee employee = empoRepo.findById(id).get();
        aziza.addObject("em",employee);
        return aziza;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee){
        empoRepo.save(employee);
        return "redirect:/list";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Integer id){
        empoRepo.deleteById(id);
        return "redirect:/list";
    }

}
