package br.com.Appetite.gerenciamentoPedido.produto;

import java.math.BigDecimal;

public record ProdutoResponseDTO(
        String id,
        String nome,
        String descricao,
        BigDecimal valor,
        boolean status,
        String categoria
) {
public ProdutoResponseDTO(Produto produto){
    this(
            produto.getId(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getValor(),
            produto.getStatus(),
            produto.getCategoria().getNome()
    );
    }
}
