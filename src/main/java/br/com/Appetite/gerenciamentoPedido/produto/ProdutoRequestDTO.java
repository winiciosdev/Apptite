package br.com.Appetite.gerenciamentoPedido.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.math.BigDecimal;

public record ProdutoRequestDTO(

        @NotBlank(message = "É obrigatório fornecer um nome")
        String nome,

        @NotBlank(message = "É obrigatório fornecer uma descrição")
        String descricao,

        @NotNull(message = "É obrigatório fornecer uma categoria")
        int idCategoria,

        @NotNull(message = "É obrigatório fornecer um valor positivo")
        @Positive
        BigDecimal valor,

        Boolean status
) {
}
