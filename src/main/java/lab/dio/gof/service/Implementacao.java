package lab.dio.gof.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.dio.gof.model.Cliente;
import lab.dio.gof.model.ClienteRepository;
import lab.dio.gof.model.Endereco;
import lab.dio.gof.model.EnderecoRepository;

@Service
public class Implementacao implements ClienteService {

    @Autowired
    private ClienteRepository clientes;
    @Autowired
    private EnderecoRepository enderecos;
    @Autowired
    private ViaCepApiService cepService;

    @Override
    public void adicionar(Cliente cliente) {
        atualizarEndereco(cliente);
    }

    @Override
    public Iterable<Cliente> exibirTodos() {
        return clientes.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
       Optional<Cliente> clienteId = clientes.findById(id);
        return clienteId.get();
    }

    @Override
    public void atualizarEndereco(Cliente cliente) {

		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecos.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = cepService.consultarCep(cep);
			enderecos.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clientes.save(cliente);
        
		
    }

    @Override
    public void atualizarTelefone(String telefone, Cliente cliente) {
        cliente.setTelefone(telefone);
    }

    @Override
    public void apagarRegistro(Long id) {
        clientes.deleteById(id);
    }

    
}
