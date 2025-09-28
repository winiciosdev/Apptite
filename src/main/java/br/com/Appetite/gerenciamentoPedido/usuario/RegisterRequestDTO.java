package br.com.Appetite.gerenciamentoPedido.usuario;

public record RegisterRequestDTO(
        String login,
        String password,
        UserRole role,
        String nome,
        String sobrenome,
        String telefone) {
}
