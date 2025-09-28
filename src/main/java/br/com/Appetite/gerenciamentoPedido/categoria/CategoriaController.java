package br.com.Appetite.gerenciamentoPedido.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> registrar(@RequestBody CategoriaRequestDTO dto){
        Categoria categoria = categoriaService.registrarCategoria(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CategoriaResponseDTO(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> buscarPeloId(@PathVariable long id){
        Categoria categoria = categoriaService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CategoriaResponseDTO(categoria));
    }

    /*

    @GetMapping
    public ResponseEntity<Page<CategoriaResponseDTO>> listarCategorias(Pageable pageable){
        Page<Categoria> paginaCategorias = categoriaService.listaCategorias(pageable);

        Page<CategoriaResponseDTO> paginaDTOs = paginaCategorias.map(CategoriaResponseDTO::new);

        return ResponseEntity.ok(paginaDTOs);
    }


     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable long id){
    categoriaService.deletaCategoria(id);

    return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaRequestDTO dto){
        Categoria categoria = categoriaService.atualizarCategoria(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(new CategoriaResponseDTO(categoria));
    }

}
