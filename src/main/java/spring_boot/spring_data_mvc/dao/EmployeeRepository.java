package spring_boot.spring_data_mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_boot.spring_data_mvc.entity.Employee;

import java.sql.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public List<Employee> findAll();
    public List<Employee> findAllByWorksBetween(Date date1,Date date2);
    public List<Employee> findAllByName(String name);
    public Employee save(Employee employee);
    public Employee findById(int id);
    public Employee deleteById(int id);

}
