package model;

import java.util.UUID;

public class DestinoRepository extends Repository<IDestino> {
    public DestinoRepository() {
        super("repository/destinos.csv");
    }

    // Método para converter um usuário para uma linha CSV
    protected String objetoParaCsv(IDestino destino) {
        // COLUNAS: id, nome, descricao, categoria
        return destino.getId() + "," + destino.getNome() + "," + destino.getDescricao() + ","
                + destino.getCategoria().name();
    }

    // Método para converter uma linha CSV para um usuário
    protected IDestino csvParaObjeto(String csvLine) {
        String[] data = csvLine.split(",");
        // COLUNAS: id, nome, descricao, categoria
        UUID id = UUID.fromString(data[0]);
        CategoriaDestino categoria = CategoriaDestino.valueOf(data[3]);
        return new Destino(data[1], data[2], categoria, id);
    }
}
