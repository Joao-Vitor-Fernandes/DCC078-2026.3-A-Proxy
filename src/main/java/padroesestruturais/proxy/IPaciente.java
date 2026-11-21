package padroesestruturais.proxy;

import java.util.List;

public interface IPaciente {
    List<String> obterDadosCadastrais();
    List<String> obterHistoricoClinico(ProfissionalSaude profissional);
}
