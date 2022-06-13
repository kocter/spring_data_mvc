package spring_boot.spring_data_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_boot.spring_data_mvc.dao.EmployeeRepository;
import spring_boot.spring_data_mvc.entity.Employee;

import java.sql.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllByWorksBetween(Date date1, Date date2) {
        List<Employee> employees = employeeRepository.findAllByWorksBetween(date1,date2);
        return employees;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> employees = employeeRepository.findAllByName(name);
        return employees;
    }


    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee deleteById(int id) {
        return employeeRepository.deleteById(id);
    }
}
