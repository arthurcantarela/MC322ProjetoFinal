package model;

public class UsuarioRepository extends Repository<IUsuario> {
    public UsuarioRepository() {
        super("repository/usuarios.csv");
    }

    // Método para converter um usuário para uma linha CSV
    protected String objetoParaCsv(IUsuario usuario) {
        return usuario.getNome() + "," + usuario.getEmail();
    }

    // Método para converter uma linha CSV para um usuário
    protected IUsuario csvParaObjeto(String csvLine) {
        String[] data = csvLine.split(",");
        return new Usuario(data[0], data[1]);
    }
}
