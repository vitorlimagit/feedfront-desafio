package com.ciandt.feedfront.services;



import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.repositories.FeedbackRepository;

import java.util.List;

//TODO: IMPLEMENTE AS CLASSES E MAPEIE A CLASSE PARA O SPRINGBOOT



public class FeedbackServiceImpl implements FeedbackService {


    private FeedbackRepository feedBackRepository;


    @Override
    public List<Feedback> listar() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Feedback buscar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Feedback salvar(Feedback feedback) throws BusinessException, IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

}
