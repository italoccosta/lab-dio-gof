package lab.dio.gof.service;

import lab.dio.gof.model.Cliente;

public interface ClienteService {
    
    void adicionar(Cliente cliente);

    Iterable<Cliente> exibirTodos();

    Cliente buscarPorId(Long id);

    void atualizarEndereco(Cliente cliente);

    void atualizarTelefone(String telefone, Cliente cliente);

    void apagarRegistro(Long id);
    
}
