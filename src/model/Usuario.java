package model;

public class Usuario implements IUsuario {
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    
    public Usuario(IUsuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    // Implementação do método getNome
    @Override
    public String getNome() {
        return nome;
    }

    // Implementação do método getEmail
    @Override
    public String getEmail() {
        return email;
    }

    // Método toString para facilitar a visualização das informações do usuário
    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
