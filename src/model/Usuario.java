package model;

import exceptions.ReservaIndisponivelException;

public class Usuario implements IUsuario {
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
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
    @Override
    public void fazerReserva(PacoteViagem pacote) throws ReservaIndisponivelException {
        if (pacote.isDisponivel()) {
            pacote.reservar();
            System.out.println("Reserva feita com sucesso para o usuário: " + getNome());
        } else {
            throw new ReservaIndisponivelException("Reserva não pode ser feita. Pacote não está disponível.");
        }
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
