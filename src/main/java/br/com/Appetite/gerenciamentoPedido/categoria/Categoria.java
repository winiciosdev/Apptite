package br.com.Appetite.gerenciamentoPedido.categoria;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "categoria")
@Table(name = "categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    public Categoria(CategoriaRequestDTO dto){
        this.nome = dto.nome();
        this.descricao = dto.descricao();
    }
}
