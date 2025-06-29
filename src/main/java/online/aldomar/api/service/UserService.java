package online.aldomar.api.service;

public class UserService {

    public String createUser(String username, String email) {
        // Lógica para criar um novo usuário
        // Exemplo simples: retorna uma mensagem de sucesso
        return "Usuário criado: " + username + " (" + email + ")";
    }

    public String getUser(String username) {
        // Lógica para buscar um usuário pelo nome
        // Exemplo simples: retorna uma mensagem simulando a busca
        return "Usuário encontrado: " + username;
    }

    public String updateUser(String username, String newEmail) {
        // Lógica para atualizar o email do usuário
        // Exemplo simples: retorna uma mensagem de sucesso
        return "Usuário atualizado: " + username + " (novo email: " + newEmail + ")";
    }

    public String deleteUser(String username) {
        // Lógica para deletar um usuário
        // Exemplo simples: retorna uma mensagem de sucesso
        return "Usuário deletado: " + username;
    }
}
