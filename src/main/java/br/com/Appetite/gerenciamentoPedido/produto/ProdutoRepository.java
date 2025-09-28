package br.com.Appetite.gerenciamentoPedido.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository <Produto, String> {

   Optional<Produto> findByNome(String nome);
}
