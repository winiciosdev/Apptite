package br.com.Appetite.gerenciamentoPedido.produto;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping
    public ProdutoResponseDTO registroDeProduto(@Valid @RequestBody ProdutoRequestDTO dto){
        return produtoService.registrarProduto(dto);
    }
}
