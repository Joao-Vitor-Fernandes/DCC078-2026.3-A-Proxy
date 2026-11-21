package padroesestruturais.proxy;

import java.util.List;

public class PacienteProxy implements IPaciente {

    private Paciente paciente;

    private Integer numeroProntuario;

    public PacienteProxy(Integer numeroProntuario) {
        this.numeroProntuario = numeroProntuario;
    }

    @Override
    public List<String> obterDadosCadastrais() {
        if (this.paciente == null) {
            this.paciente = new Paciente(this.numeroProntuario);
        }
        return this.paciente.obterDadosCadastrais();
    }

    @Override
    public List<String> obterHistoricoClinico(ProfissionalSaude profissional) {
        if (!profissional.isMedico()) {
            throw new IllegalArgumentException("Profissional não autorizado");
        }
        if (this.paciente == null) {
            this.paciente = new Paciente(this.numeroProntuario);
        }
        return this.paciente.obterHistoricoClinico(profissional);
    }
}