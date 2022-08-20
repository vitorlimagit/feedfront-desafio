package com.ciandt.feedfront.controllers;


import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.services.FeedbackService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


//TODO: APLIQUE AS ANOTAÇÕES NECESSÁRIAS PARA QUE O PROGRAMA RECONHEÇA AS DIFERENTES CAMADAS COMO @SERVICE, @RESTCONTROLLER. NÃO ESQUEÇA DAS INJEÇÕES DE DEPENDENCIA COM O @AUTOWIRED
//TODO: APLIQUE AS ANOTAÇÕES DO SWAGGER CONFORME O EXEMPLO @ApiOperation

@RequestMapping("/v1/feedbacks")
public class FeedbackController {


    private FeedbackService feedbackService;


    @ApiOperation(value = "Este retorna todos os dados enviados pelos usuários no banco de dados.")
    @GetMapping
    public ResponseEntity<List<Feedback>> listar() {
        throw new UnsupportedOperationException();
    }

    public ResponseEntity<Feedback> buscar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public ResponseEntity<Feedback> salvar(@RequestBody Feedback feedback) throws BusinessException {
        throw new UnsupportedOperationException();
    }
}
