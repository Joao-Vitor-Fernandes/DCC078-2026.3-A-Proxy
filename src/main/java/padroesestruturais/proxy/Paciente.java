package padroesestruturais.proxy;

import java.util.Arrays;
import java.util.List;

public class Paciente implements IPaciente {

    private Integer numeroProntuario;
    private String nome;
    private String convenio;
    private String diagnostico;
    private String medicamento;

    public Paciente(Integer numeroProntuario) {
        this.numeroProntuario = numeroProntuario;
        Paciente objeto = BD.getPaciente(numeroProntuario);
        this.nome = objeto.nome;
        this.convenio = objeto.convenio;
        this.diagnostico = objeto.diagnostico;
        this.medicamento = objeto.medicamento;
    }

    public Paciente(Integer numeroProntuario, String nome, String convenio, String diagnostico, String medicamento) {
        this.numeroProntuario = numeroProntuario;
        this.nome = nome;
        this.convenio = convenio;
        this.diagnostico = diagnostico;
        this.medicamento = medicamento;
    }

    public Integer getNumeroProntuario() {
        return numeroProntuario;
    }

    @Override
    public List<String> obterDadosCadastrais() {
        return Arrays.asList(this.nome, this.convenio);
    }

    @Override
    public List<String> obterHistoricoClinico(ProfissionalSaude profissional) {
        return Arrays.asList(this.diagnostico, this.medicamento);
    }
}