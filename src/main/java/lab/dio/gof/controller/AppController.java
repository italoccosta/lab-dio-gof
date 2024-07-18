package lab.dio.gof.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab.dio.gof.model.Cliente;
import lab.dio.gof.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class AppController {

    @Autowired
    private ClienteService clientes;

    @PostMapping
    public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente) {
        clientes.adicionar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping
    public ResponseEntity<Cliente> atualizarEndereco(@PathVariable Long id, @RequestBody Cliente cliente) {
        clientes.atualizarEndereco(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarTelefone (@PathVariable String telefone, @RequestBody Cliente cliente) {
        clientes.atualizarTelefone(telefone, cliente);
        return ResponseEntity.ok(cliente);
    }


    @GetMapping
    public ResponseEntity<Iterable<Cliente>> exibirTodos() {
        return ResponseEntity.ok(clientes.exibirTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> encontrarPorId(Long id) {
        return ResponseEntity.ok(clientes.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarCliente(Long id) {
        clientes.apagarRegistro(id);
        return ResponseEntity.ok().build();
    }



    
}
