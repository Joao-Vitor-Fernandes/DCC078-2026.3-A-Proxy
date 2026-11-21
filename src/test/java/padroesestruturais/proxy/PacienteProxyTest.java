package padroesestruturais.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PacienteProxyTest {

    @BeforeEach
    void setUp() {
        BD.limpar();
        BD.addPaciente(new Paciente(1, "Carlos", "Unimed", "Hipertensão", "Losartana"));
        BD.addPaciente(new Paciente(2, "Fernanda", "Amil", "Diabetes tipo 2", "Metformina"));
    }

    @Test
    void deveRetornarDadosCadastraisPaciente() {
        PacienteProxy paciente = new PacienteProxy(1);

        assertEquals(Arrays.asList("Carlos", "Unimed"), paciente.obterDadosCadastrais());
    }

    @Test
    void deveRetornarHistoricoClinicoParaMedico() {
        ProfissionalSaude medica = new ProfissionalSaude("Dra. Ana", true);
        PacienteProxy paciente = new PacienteProxy(2);

        assertEquals(Arrays.asList("Diabetes tipo 2", "Metformina"), paciente.obterHistoricoClinico(medica));
    }

    @Test
    void deveRetonarExcecaoProfissionalNaoAutorizadoConsultarHistoricoClinicoPaciente() {
        try {
            ProfissionalSaude medica = new ProfissionalSaude("Augusto", false);
            PacienteProxy paciente = new PacienteProxy(2);

            paciente.obterHistoricoClinico(medica);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Profissional não autorizado", e.getMessage());
        }
    }
}
