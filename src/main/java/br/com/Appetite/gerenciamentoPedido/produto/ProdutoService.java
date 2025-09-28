package br.com.Appetite.gerenciamentoPedido.produto;

import br.com.Appetite.gerenciamentoPedido.categoria.Categoria;
import br.com.Appetite.gerenciamentoPedido.categoria.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository){
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public ProdutoResponseDTO registrarProduto(ProdutoRequestDTO dto){
        Categoria categoria = categoriaRepository.findById(dto.idCategoria())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não foi encontrada"));


        Produto novoProduto = new Produto(dto, categoria);
        if(dto.status() == null) novoProduto.setStatus(true);
        produtoRepository.save(novoProduto);
        return new ProdutoResponseDTO(novoProduto);
    }
}
