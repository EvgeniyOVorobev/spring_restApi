package com.ev.spring.rest.dao;

import com.ev.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;


    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees=session.createQuery("from Employee ", Employee.class)
                . getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session=sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployees(int id) {
        Session session=sessionFactory.getCurrentSession();
        Employee employee=session.get(Employee.class,id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session=sessionFactory.getCurrentSession();
        Query<Employee> employeeQuery=session.createQuery("delete from Employee where id=:employeeId");
        employeeQuery.setParameter("employeeId",id);
        employeeQuery.executeUpdate();
    }
}
