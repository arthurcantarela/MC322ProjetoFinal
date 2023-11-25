package model;

import exceptions.ReservaIndisponivelException;

public class UsuarioBase implements IUsuario {
    private String nome;
    private String email;

    public UsuarioBase(String nome, String email) {
        this.nome = nome;
        this.email = email;
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

    // Implementação do método fazerReserva
    public void ReservarPacote(PacoteViagem pacote) throws ReservaIndisponivelException {
    	pacote.fazerReserva(this);
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
