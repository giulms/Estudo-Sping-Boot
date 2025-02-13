package io.github.giulms.produtosapi.controller;

import io.github.giulms.produtosapi.model.Produto;
import io.github.giulms.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

//Diz para o spring que a classe vai receber requisições REST
@RestController
//Indica o mapa a ser acessado na URl ex: localhost:8080/produtos
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    //Crio um construtor
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //Indica o tipo de requisição e posso ou não colocar o caminho ex:(/produtos)
    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto recebido: " + produto);

        //UUID é uma classe que serve pra gerar códigos unicos
        var id = UUID.randomUUID().toString();
        produto.setId(id);

        //Escolho o metodo que vou usar no repositorio
        produtoRepository.save(produto);
        return produto;
    }

    //Posso colocar mais parametros da URL como /{id}/{nome}/{preco}
    @GetMapping("/{id}")
    //Esse PathVariable indica que o id de cima se refere ao id de baixo tipo o body da requisição só que no caso é na URL
    public Produto obterPorId(@PathVariable("id") String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }
}
