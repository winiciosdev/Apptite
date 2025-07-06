package br.com.Appetite.gerenciamentoPedido.users;

public record RegisterRequestDTO(String login, String password, UserRole role) {
}
