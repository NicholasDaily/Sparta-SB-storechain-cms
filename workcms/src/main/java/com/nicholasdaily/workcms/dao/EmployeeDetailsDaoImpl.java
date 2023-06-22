package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.EmployeeDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDetailsDaoImpl implements EmployeeDetailsDao{
    EntityManager manager;

    EmployeeDetailsDaoImpl(EntityManager manager){
        this.manager = manager;
    }

    @Override
    public EmployeeDetails getEmployeeDetailsById(int id) {
        return manager.find(EmployeeDetails.class, id);
    }

    @Override
    public List<EmployeeDetails> getAllEmployeeDetails() {
        TypedQuery<EmployeeDetails> query = manager.createQuery("FROM EmployeeDetails", EmployeeDetails.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public EmployeeDetails updateEmployeeDetails(EmployeeDetails employeeDetails) {
        return manager.merge(employeeDetails);
    }

    @Override
    public void deleteEmployeeDetails(EmployeeDetails employeeDetails) {
        deleteEmployeeDetailsById(employeeDetails.getId());
    }

    @Override
    @Transactional
    public void deleteEmployeeDetailsById(int id) {
        EmployeeDetails tempEmployeeDetails = manager.find(EmployeeDetails.class, id);
        manager.remove(tempEmployeeDetails);
    }

    @Override
    @Transactional
    public void createEmployeeDetails(EmployeeDetails employeeDetails) {
        manager.persist(employeeDetails);
    }
}
