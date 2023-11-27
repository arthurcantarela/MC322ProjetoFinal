package model;

public class UsuarioRepository extends Repository<IUsuario> {
    public UsuarioRepository() {
        super("repository/usuarios.csv");
    }

    // Método para converter um usuário para uma linha CSV
    protected String objetoParaCsv(IUsuario usuario) {
        return usuario.getNome() + "," + usuario.getEmail() + "," + (usuario instanceof UsuarioAdmin ? "admin" : "user");
    }

    // Método para converter uma linha CSV para um usuário
    protected IUsuario csvParaObjeto(String csvLine) {
        String[] data = csvLine.split(",");
        if (data[2].equals("admin"))
            return new UsuarioAdmin(data[0], data[1]);
        return new Usuario(data[0], data[1]);
    }
}
