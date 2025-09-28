package br.com.Appetite.gerenciamentoPedido.produto;

import br.com.Appetite.gerenciamentoPedido.categoria.Categoria;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;

@Table(name = "produto")
@Entity(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "status")
    private Boolean status;

    public Produto(ProdutoRequestDTO dto,Categoria categoria) {
        this.categoria = categoria;
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.valor = dto.valor();
        this.status = dto.status();
    }
}
