package com.ciandt.feedfront.controller;

import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.services.EmployeeService;

import java.util.List;

public class EmployeeController {
    private Service<Employee> service;

    public EmployeeController() {
        this.service = new EmployeeService();
    }

    public List<Employee> listar() throws ArquivoException {
        return this.service.listar();
    }

    public Employee buscar(String id) throws BusinessException, ArquivoException {
        return this.service.buscar(id);
    }

    public Employee salvar(Employee employee) throws BusinessException, ArquivoException {
        return this.service.salvar(employee);
    }

    public Employee atualizar(Employee employee) throws BusinessException, ArquivoException {
        return this.service.atualizar(employee);
    }

    public void apagar(String id) throws BusinessException, ArquivoException {
        this.service.apagar(id);
    }

    public void setService(Service<Employee> service) {
        this.service = service;
    }
}