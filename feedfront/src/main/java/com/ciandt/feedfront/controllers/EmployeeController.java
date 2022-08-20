package com.ciandt.feedfront.controllers;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//TODO: APLIQUE AS ANOTAÇÕES NECESSÁRIAS PARA QUE O PROGRAMA RECONHEÇA AS DIFERENTES CAMADAS COMO @SERVICE, @RESTCONTROLLER. NÃO ESQUEÇA DAS INJEÇÕES DE DEPENDENCIA COM O @AUTOWIRED
//TODO: APLIQUE AS ANOTAÇÕES DO SWAGGER CONFORME O EXEMPLO @ApiOperation EM FEEDBACKCONTROLLER.

@RequestMapping("/v1/employees")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Utilize o exemplo de salvar na classe FeedbackController para implementar os métodos:

    public ResponseEntity<List<Employee>> listar()  {
    throw new UnsupportedOperationException();

   }

    public ResponseEntity<Employee> buscar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    @PostMapping
    public ResponseEntity<Employee> salvar(@RequestBody Employee employee) throws BusinessException {

        employee = employeeService.salvar(employee);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(employee.getId()).toUri();

        return ResponseEntity.created(uri).body(employee);
    }

    public ResponseEntity apagar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public ResponseEntity<Employee> atualizar (Employee employee) throws BusinessException {
        throw new UnsupportedOperationException();
    }
}