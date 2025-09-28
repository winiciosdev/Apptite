package br.com.Appetite.gerenciamentoPedido.categoria;

import br.com.Appetite.gerenciamentoPedido.erros.RecursoNaoEncontradoException;
import br.com.Appetite.gerenciamentoPedido.erros.RegraNegocioException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria registrarCategoria(CategoriaRequestDTO dto){

        categoriaRepository.findByNome(dto.nome()).ifPresent(categoria -> {throw new RegraNegocioException("Já existe uma categoria registrada com o nome: " + dto.nome());
        });

        Categoria novaCategoria = new Categoria(dto);
        return categoriaRepository.save(novaCategoria);

    }

    public void deletaCategoria(Long id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada com o ID: " + id));
        categoriaRepository.delete(categoria);
    }

    public Categoria buscarPorId(Long id){

        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada com o ID: " + id));

        return categoria;
    }

    /*
    public Page<Categoria> listaCategorias(Pageable pageable){
    return categoriaRepository.findAll(pageable);
    } */

    public Categoria atualizarCategoria(Long id, CategoriaRequestDTO dto){

        Categoria categoriaExistente = categoriaRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada com o ID: " + id));

        Optional<Categoria> categoria = categoriaRepository.findByNome(dto.nome());
        if (categoria.isPresent() && !categoria.get().getId().equals(id)){
            throw  new RegraNegocioException("Este nome já pertence a uma categoria.");
        }

        categoriaExistente.setNome(dto.nome());
        categoriaExistente.setDescricao(dto.descricao());

        return categoriaRepository.save(categoriaExistente);

    }
}
