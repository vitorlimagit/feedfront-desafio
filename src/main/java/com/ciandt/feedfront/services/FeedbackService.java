package com.ciandt.feedfront.services;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.daos.FeedbackDAO;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.excecoes.EntidadeNaoEncontradaException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.models.Feedback;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class FeedbackService implements Service<Feedback> {
    private DAO<Feedback> dao;
    private Service<Employee> employeeService;

    public FeedbackService() {
        setDAO(new FeedbackDAO());
        setEmployeeService(new EmployeeService());
    }

    @Override
    public List<Feedback> listar() throws ArquivoException {
        List<Feedback> feedbacks;

        try {
            feedbacks = this.dao.listar();
        } catch (IOException e) {
            throw new ArquivoException(e.getMessage());
        }

        return feedbacks;
    }

    @Override
    public Feedback buscar(String id) throws ArquivoException, BusinessException {
        Feedback feedback;

        try {
            feedback = this.dao.buscar(id);
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                throw new EntidadeNaoEncontradaException("não foi possível encontrar o feedback");
            }

            throw new ArquivoException(e.getMessage());
        }

        return feedback;
    }

    @Override
    public Feedback salvar(Feedback feedback) throws ArquivoException, BusinessException, IllegalArgumentException {
        if (feedback == null) {
            throw new IllegalArgumentException("feedback inválido");
        }

        if (feedback.getProprietario() == null) {
            throw new IllegalArgumentException("employee inválido");
        }

        String idProprietario = feedback.getProprietario().getId();
        employeeService.buscar(idProprietario); //valida se o proprietário está salvo

        Feedback feedbackSalvo;

        try {
            feedbackSalvo = this.dao.salvar(feedback);
        } catch (IOException e) {
            throw new ArquivoException(e.getMessage());
        }

        return feedbackSalvo;
    }

    @Override
    public Feedback atualizar(Feedback feedback) throws ArquivoException, BusinessException, IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void apagar(String id) throws ArquivoException, BusinessException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDAO(DAO<Feedback> dao) {
        this.dao = dao;
    }

    public void setEmployeeService(Service<Employee> employeeService) {
        this.employeeService = employeeService;
    }
}
