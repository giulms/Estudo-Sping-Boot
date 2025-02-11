package io.github.giulms.produtosapi.controller;

import io.github.giulms.produtosapi.model.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Diz para o spring que a classe vai receber requisições REST
@RestController
//Indica o mapa a ser acessado na URl ex: localhost:8080/produtos
@RequestMapping("/produtos")
public class ProdutoController {

//Indica o tipo de requisição e posso ou não colocar o caminho ex:(/produtos)
    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto recebido: " + produto);
        return produto;
    }
}
