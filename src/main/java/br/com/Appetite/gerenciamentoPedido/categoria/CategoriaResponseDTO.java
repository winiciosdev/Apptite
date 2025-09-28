package br.com.Appetite.gerenciamentoPedido.categoria;

public record CategoriaResponseDTO(Long id, String nome, String descricao) {

    public CategoriaResponseDTO(Categoria categoria){
        this(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }
}
