package com.ciandt.feedfront.controllers;

//import com.ciandt.feedfront.controllers.FeedbackController;
import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.controller.EmployeeController;
import com.ciandt.feedfront.controller.FeedbackController;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import com.ciandt.feedfront.models.Employee;
//import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.services.FeedbackService;
import com.ciandt.feedfront.utils.LimparRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import java.util.Collection;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

public class FeedbackControllerTest {

    private Feedback feedback;

    private Employee autor;

    private Employee proprietario;

    private FeedbackController controller;
    private Service<Feedback> feedbackService;

    @BeforeEach
    @SuppressWarnings("unchecked")
    public void initEach() throws IOException, BusinessException {
        feedbackService = (Service<Feedback>) Mockito.mock(Service.class);

        controller = new FeedbackController();
        controller.setService(feedbackService);

        autor = new Employee("João", "Silveira", "j.silveira@email.com");
        proprietario = new Employee("Mateus", "Santos", "m.santos@email.com");

        feedback = new Feedback(LocalDate.now(), autor, proprietario,"Agradeco muito pelo apoio feito pelo colega!");//construtor 1

        when(feedbackService.salvar(feedback)).thenReturn(feedback);
        controller.salvar(feedback);
    }

    @Test
    public void listar() throws ArquivoException {
        Collection<Feedback> listaFeedback = controller.listar();

        assertNotNull(listaFeedback);
    }

    @Test
    public void salvar() {
        assertDoesNotThrow(() -> controller.salvar(feedback));
    }

    @Test
    public void buscar() throws BusinessException, ArquivoException {
        String uuid = feedback.getId();

        when(feedbackService.buscar(uuid)).thenReturn(feedback);
        Feedback feedbackSalvo = assertDoesNotThrow(() -> controller.buscar(uuid));

        assertEquals(feedback, feedbackSalvo);
    }
}
