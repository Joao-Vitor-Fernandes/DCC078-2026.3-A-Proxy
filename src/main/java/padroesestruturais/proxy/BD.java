package padroesestruturais.proxy;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static final Map<Integer, Paciente> pacientes = new HashMap<>();

    public static Paciente getPaciente(Integer numeroProntuario) {
        return pacientes.get(numeroProntuario);
    }

    public static void addPaciente(Paciente paciente) {
        pacientes.put(paciente.getNumeroProntuario(), paciente);
    }

    public static void limpar() {
        pacientes.clear();
    }
}