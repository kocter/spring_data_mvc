package spring_boot.spring_data_mvc.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import spring_boot.spring_data_mvc.entity.Employee;
import spring_boot.spring_data_mvc.service.EmployeeService;

import java.sql.Date;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;



@Controller
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;



    @RequestMapping("/")
    public String getWelcome(){
        return "welcome";
    }

    @RequestMapping("/classified-information")
    public String getSecret(){
        return "classified-information";
    }


    @GetMapping("/people")
    public String index(Model model1,Model model2) {
        List<Employee> employees = employeeService.findAll();
        model1.addAttribute("employee", employees);
        model2.addAttribute("count",employees.stream().count());
        return "people";
    }

    @RequestMapping("/addNewPeople")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "people-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:people";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id,Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "people-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id,Model model){
        Employee employee = employeeService.deleteById(id);
        return "redirect:people";
    }



//    @GetMapping("/employees/date/{date1}&{date2}")
//    public String searchByExperience(@PathVariable Date date1, @PathVariable Date date2){
//        List<Employee> employees = employeeService.findAllByWorksBetween(date1,date2);
//        return "search-result";
//    }


    @GetMapping("/enterDate")
    public String enterDate(){

        return "search-by-time";
    }


    //Поиск людей по стажу
    @GetMapping("/searchByTime")
    public String searchByExperience(@RequestParam("from") Date from, @RequestParam("to") Date to, Model model1, Model model2){

        List<Employee> employees = employeeService.findAllByWorksBetween(from,to);
        model1.addAttribute("employee", employees);
        model2.addAttribute("count",employees.stream().count());
        return "search-result";
    }


    @GetMapping("/enterName")
    public String enterName(){

        return "search-by-name";
    }

    @GetMapping("/enterExperience")
    public String enterExperience(){

        return "search-by-experience";
    }


    @GetMapping("/searchByName")
    public String findByName(@RequestParam("text") String name,Model model1,Model model2){

        List<Employee> employees = employeeService.findAllByName(name);
        model1.addAttribute("employee", employees);
        model2.addAttribute("count",employees.stream().count());
        return "search-result";
    }


    @GetMapping("/searchByExperience")
    public String searchByExperience(@RequestParam("exp") int exp,Model model1,Model model2){

        List<Employee> employees = employeeService.findAll();
        Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        System.out.println(exp);




        List<Employee>employeeExp = new ArrayList<>();
        for(Employee e: employees){

            if(date.getYear()-e.getWorks().getYear()>=exp){
                employeeExp.add(e);

            }
        }
        model1.addAttribute("employee", employeeExp);
        model2.addAttribute("count",employeeExp.stream().count());
        return "search-result";
    }


}
