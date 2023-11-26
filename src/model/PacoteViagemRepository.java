package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

public class PacoteViagemRepository extends Repository<IPacoteViagem> {
    private HashMap<UUID, IDestino> destinos;
    private HashMap<String, IUsuario> usuarios;

    public PacoteViagemRepository(HashMap<UUID, IDestino> destinos, HashMap<String, IUsuario> usuarios) {
        super("repository/pacotes.csv");
        this.destinos = destinos;
        this.usuarios = usuarios;
    }

    // Método para converter um usuário para uma linha CSV
    protected String objetoParaCsv(IPacoteViagem pacote) {
        IDestino destino = pacote.getDestino();
        IUsuario usuario = pacote.getUsuario();
        String usuarioEmail = usuario == null ? "" : usuario.getEmail();
        // COLUNAS: destino.id, usuario.email, preco, dataInicio, dataFim
        return destino.getId() + "," + usuarioEmail + "," + Double.toString(pacote.getPreco()) + ","
                + pacote.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + ","
                + pacote.getDataFim().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    // Método para converter uma linha CSV para um usuário
    protected IPacoteViagem csvParaObjeto(String csvLine) {
        String[] data = csvLine.split(",");
        // COLUNAS: destino.id, usuario.email, preco, dataInicio, dataFim
        UUID destinoId = UUID.fromString(data[0]);
        IDestino destino = destinos.get(destinoId);
        String usuarioEmail = data[1];
        IUsuario usuario = usuarioEmail.length() == 0 ? null : usuarios.get(usuarioEmail);
        double preco = Double.parseDouble(data[2]);
        LocalDate dataInicio = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataFim = LocalDate.parse(data[4], DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return new PacoteViagem(destino, preco, dataInicio, dataFim, usuario);
    }
}
