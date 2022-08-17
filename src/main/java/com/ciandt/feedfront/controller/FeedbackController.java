package com.ciandt.feedfront.controller;

import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.services.FeedbackService;

import java.util.List;

public class FeedbackController {
    private Service<Feedback> service;

    public FeedbackController() {
        setService(new FeedbackService());
    }

    public List<Feedback> listar() throws ArquivoException {
        return this.service.listar();
    }

    public Feedback buscar(String id) throws BusinessException, ArquivoException {
        return this.service.buscar(id);
    }

    public Feedback salvar(Feedback feedback) throws BusinessException, ArquivoException {
        return this.service.salvar(feedback);
    }

    public void setService(Service<Feedback> service) {
        this.service = service;
    }
}
