package com.ciandt.feedfront.services;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//TODO: IMPLEMENTE AS CLASSES E MAPEIE A CLASSE PARA O SPRINGBOOT

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listar() {

        throw new UnsupportedOperationException();
    }

    @Override
    public Employee buscar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Employee salvar(Employee employee) throws BusinessException {

        return employeeRepository.save(employee);
    }

    @Override
    public Employee atualizar(Employee employee) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void apagar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }
}