package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.models.Feedback;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class FeedbackDAOTest {
    private Feedback feedback;
    private DAO<Feedback> feedbackDAO;

    private Employee autor;
    private Employee proprietario;
    private final LocalDate localDate = LocalDate.now();
    private final String LOREM_IPSUM_FEEDBACK = "Lorem Ipsum is simply dummy text of the printing and typesetting industry";


    @BeforeEach
    public void initEach() throws IOException, ComprimentoInvalidoException {
        // Este trecho de código serve somente para limpar o repositório
        Files.walk(Paths.get("src/main/resources/data/feedback/"))
                .filter(p -> p.toString().endsWith(".byte"))
                .forEach(p -> {
                    new File(p.toString()).delete();
                });

        autor = new Employee("João", "Silveira", "j.silveira@email.com");
        proprietario = new Employee("Mateus", "Santos", "m.santos@email.com");

        feedbackDAO = new FeedbackDAO();
        feedback = new Feedback(localDate, autor, proprietario, LOREM_IPSUM_FEEDBACK);

        feedbackDAO.salvar(feedback);
    }

    @Test
    public void listar() throws IOException {
        List<Feedback> result = feedbackDAO.listar();

        assertFalse(result.isEmpty());
    }

    @Test
    public void buscar() {
        String idValido = feedback.getId();
        String idInvalido = UUID.randomUUID().toString();

        assertThrows(IOException.class, () -> feedbackDAO.buscar(idInvalido));
        Feedback feedbackSalvo = assertDoesNotThrow(() -> feedbackDAO.buscar(idValido));

        assertEquals(feedbackSalvo, feedback);
    }

    @Test
    public void salvar() throws ComprimentoInvalidoException {
        Feedback novoFeedback = new Feedback(LocalDate.now(), autor, proprietario, "novo feedback");

        Feedback feedbackSalvo = assertDoesNotThrow(() -> feedbackDAO.salvar(novoFeedback));
        assertEquals(feedbackSalvo, novoFeedback);
    }

}
