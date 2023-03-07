package com.ev.spring.rest.dao;

import com.ev.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

   public Employee getEmployees(int id);

   public void deleteEmployee(int id);
}
