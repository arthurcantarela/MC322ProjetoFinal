package main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.*;

import model.*;
import controller.*;
import exceptions.ReservaIndisponivelException;
import view.*;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    //private static final Map<String, String> usuarios = new HashMap<>();
    //private static final Map<String, IUsuario> usuarios = new HashMap<>();
    public static List<PacoteViagem> pacotes = new ArrayList<>();
    public static IPacoteView pacoteView = new PacoteView();
    public static IDestinoView destinoView = new DestinoView();
    public static IPacoteController pacoteController = new PacoteController();
    public static IDestinoController destinoController = new DestinoController();
    public static IReservaController reservaController = new ReservaController();
    public static IUsuarioController usuarioController = new UsuarioController();
    
    //private static final List<Reserva> reservas = new ArrayList<>();
    private static IUsuario usuarioLogado;    
    
    public static void main(String[] args) {
        // Adicionando um usuário de exemplo (admin)
        
        Destino destino = new Destino("Tokyo", "Nice Place", CategoriaDestino.CULTURAL);
        Destino destino2 = new Destino("Las Vegas", "Cassino", CategoriaDestino.AVENTURA);
        
        PacoteViagem pacote = new PacoteViagem(destino, 1800, LocalDate.now(), LocalDate.now()); 
        PacoteViagem pacote2 = new PacoteViagem(destino,2500, LocalDate.now(), LocalDate.now()); 
        PacoteViagem pacote3 = new PacoteViagem(destino2,3600, LocalDate.now(), LocalDate.now()); 
        PacoteViagem pacote4 = new PacoteViagem(destino2,5500, LocalDate.now(), LocalDate.now()); 
        
        pacotes.add(pacote);
        pacotes.add(pacote2);
        pacotes.add(pacote3);
        pacotes.add(pacote4);

        int opcao;

        do {
            System.out.println("\n----- Menu -----");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    fazerLogin();
                    break;
                case 2:
                    fazerCadastro();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            if (usuarioLogado != null) {
                if (usuarioLogado.getNome().equals("1")) {
                    menuOpcoesAdministrativas();
                } else {
                    menuOpcoesUsuario();
                }
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void fazerLogin() {
        System.out.print("Digite o email: ");
        Map<String,IUsuario> usuarios = usuarioController.mapUsuarios();
        String email = scanner.next();
        
        //System.out.print("Digite a senha: ");
        //String senha = scanner.next();
        
        IUsuario usuario = usuarios.get(email);

        if (usuario!= null) {
            System.out.println("Login bem-sucedido!");
            // Define o usuário logado
            usuarioLogado = usuario;
        } else {
            System.out.println("Usuário ou senha incorretos. Acesso negado.");
        }
    }



    private static void menuOpcoesUsuario() {
        int opcao;

        do {
            System.out.println("\n----- Menu de Opções -----");
            System.out.println("1 - Procurar Pacote");
            System.out.println("2 - Visualizar Reservas");
            System.out.println("3 - Ofertas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    procurarPacote();
                    break;
                case 2:
                    //visualizarReservas();
                    break;
                case 3:
                    exibirOfertas();
                    break;
                case 0:
                    System.out.println("Saindo do menu de opções do usuário.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    private static void procurarPacote() {
        int opcao;

        do {
            System.out.println("\n----- Procurar Pacote -----");
            System.out.println("1 - Procurar por Destino");
            System.out.println("2 - Procurar por Categoria");
            System.out.println("3 - Procurar por Preço Máximo");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    procurarPorDestino();
                    break;
                case 2:
                    procurarPorCategoria();
                    break;
                case 3:
                    procurarPorPrecoMaximo();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    private static void procurarPorDestino() {
        System.out.println("\n----- Procurar por Destino -----");
        System.out.println("1 - Visualizar Destinos Disponíveis");
        //System.out.println("2 - Inserir Destino");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                visualizarDestinosDisponiveisMenu();
                break;
            case 0:
                System.out.println("Voltando à busca por pacote.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void procurarPorCategoria() {
        System.out.println("----- Procurar por Categoria -----");
        System.out.println("Categorias Disponíveis:");
        System.out.println("1 - Aventura");
        System.out.println("2 - Relaxamento");
        System.out.println("3 - Cultural");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                exibirPacotesPorCategoria(CategoriaDestino.AVENTURA);
                break;
            case 2:
                exibirPacotesPorCategoria(CategoriaDestino.RELAXAMENTO);
                break;
            case 3:
                exibirPacotesPorCategoria(CategoriaDestino.CULTURAL);
                break;
            case 0:
                System.out.println("Voltando ao menu principal.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
    
    private static void visualizarDestinosDisponiveisMenu() {
    	List<IDestino> destinosDisponiveis = destinoController.destinosDisponiveis(pacoteController);
    	
    	System.out.println("\n--- Destinos Disponíveis ---");
    	
    	destinoView.visualizarDestinosDisponiveis(destinosDisponiveis);
    	
        System.out.println("Escolha o destino desejado: ");
        
        int opcao = scanner.nextInt();
        
        IDestino destinoSelecionado = destinosDisponiveis.get(opcao-1);
        List<IPacoteViagem> pacotesDisponiveis = pacoteController.buscarPacotesDisponiveis(destinoSelecionado);
        
        System.out.println("\n--- Pacotes Disponíveis - Destino " + destinoSelecionado.getNome() + " ---");
        pacoteView.visualizarPacotesDisponiveis(pacotesDisponiveis);
        
        System.out.println("Selecione um Pacote para Reserva (ou volte ao Menu selecionando 0)");
        
        //todo - implementar exceção de quando o usuario colocar um numero não valido para acessar o pacote.
        opcao = scanner.nextInt();
        IPacoteViagem pacoteSelecionado = pacotesDisponiveis.get(opcao-1);
        if(opcao != 0) {
        	try {
				reservaController.reservarPacote(usuarioLogado, pacoteSelecionado);
				System.out.println("Pacote para o usuário " + usuarioLogado + " com destino a " + pacotesDisponiveis.get(opcao-1).getDestino().getNome() + " reservado com sucesso!");
			} catch (ReservaIndisponivelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
    }

    private static void procurarPorPrecoMaximo() {
        System.out.print("Digite o preço máximo desejado: ");
        double precoMaximo = scanner.nextDouble();
        List<IPacoteViagem> pacotesDisponiveis = pacoteController.buscarPacotesDisponiveis(precoMaximo);
        
        System.out.println("\n--- Pacotes Disponíveis - Preço Máximo " + precoMaximo + " ---");
        
        pacoteView.visualizarPacotesDisponiveis(pacotesDisponiveis);
        
        System.out.println("Selecione um Pacote para Reserva (ou volte ao Menu selecionando 0)");
        
        int opcao = scanner.nextInt();
        IPacoteViagem pacoteSelecionado = pacotesDisponiveis.get(opcao-1);
        if(opcao != 0) {
        	try {
				reservaController.reservarPacote(usuarioLogado, pacoteSelecionado);
				System.out.println("Pacote para o usuário " + usuarioLogado + " com destino a " + pacotesDisponiveis.get(opcao-1).getDestino().getNome() + " reservado com sucesso!");
			} catch (ReservaIndisponivelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        

    }


    private static void exibirPacotesPorCategoria(CategoriaDestino categoria) {
    	int j = 0;
        List<IPacoteViagem> pacotesDisponiveis = pacoteController.buscarPacotesDisponiveis(categoria);
        
        System.out.println("\n--- Pacotes Disponíveis - Categoria " + categoria + " ---");
        
        pacoteView.visualizarPacotesDisponiveis(pacotesDisponiveis);
        
        System.out.println("Selecione um Pacote para Reserva (ou volte ao Menu selecionando 0)");
        
        int opcao = scanner.nextInt();
        IPacoteViagem pacoteSelecionado = pacotesDisponiveis.get(opcao-1);
        if(opcao != 0) {
        	try {
				reservaController.reservarPacote(usuarioLogado, pacoteSelecionado);
				System.out.println("Pacote para o usuário " + usuarioLogado + " com destino a " + pacotesDisponiveis.get(opcao-1).getDestino().getNome() + " reservado com sucesso!");
			} catch (ReservaIndisponivelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
   }


private static void exibirOfertas() {
    System.out.println("\n----- Ofertas -----");
    // Adicione aqui a lógica para exibir as ofertas disponíveis
    // ...

    // Exemplo de exibição de ofertas
    System.out.println("1 - Oferta A");
    System.out.println("2 - Oferta B");
    System.out.println("3 - Oferta C");
    System.out.print("Escolha uma oferta para mais detalhes (ou 0 para voltar): ");
    int escolha = scanner.nextInt();

    switch (escolha) {
        case 1:
            System.out.println("Detalhes da Oferta A");
            break;
        case 2:
            System.out.println("Detalhes da Oferta B");
            break;
        case 3:
            System.out.println("Detalhes da Oferta C");
            break;
        case 0:
            System.out.println("Voltando ao menu principal.");
            break;
        default:
            System.out.println("Opção inválida. Voltando ao menu principal.");
    	}
	}


public static void menuOpcoesAdministrativas(){
	int escolha;
	do {
		exibirMenu();
	    // Ler a escolha do usuário
		escolha = scanner.nextInt();
	    scanner.nextLine(); // Consumir a quebra de linha após o número

	    // Executar a opção escolhida
	    switch (escolha) {
	        case 1:
	            gerenciarDestinos();
	            break;
	        case 2:
	            gerenciarPacotes();
	            break;
	        case 3:
	            gerenciarUsuarios();
	            break;
	        case 0:
	            System.out.println("Saindo do Menu Administrativo. Até mais!");
	            break;
	        default:
	            System.out.println("Opção inválida. Tente novamente.");
	    }
	} while(escolha != 0);
	
} 



private static void exibirMenu() {
    System.out.println("\n----- Menu Administrativo -----");
    System.out.println("1 - Gerenciar Destinos");
    System.out.println("2 - Gerenciar Pacotes");
    System.out.println("3 - Gerenciar Usuarios");
    System.out.println("0 - Sair");
    System.out.print("Escolha uma opção: ");
}

private static void gerenciarDestinos() {
    
    int opcao;

    do {
        System.out.println("\n----- Gerenciar Destinos -----");
        System.out.println("1 - Inserir Destino");
        System.out.println("2 - Editar Destino");
        System.out.println("3 - Remover Destino");
        System.out.println("0 - Voltar ao Menu Administrativo");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o número

        switch (opcao) {
            case 1:
                inserirDestino();
                break;
            case 2:
                editarDestino();
                break;
            case 3:
                removerDestino();
                break;
            case 0:
                System.out.println("Voltando ao Menu Administrativo.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    } while (opcao != 0);
}

private static void inserirDestino() {
    System.out.println("\n----- Inserir Destino -----");

    System.out.print("Nome do Destino: ");
    String nome = scanner.nextLine();

    System.out.print("Descrição do Destino: ");
    String descricao = scanner.nextLine();

    System.out.println("Categorias Disponíveis:");
    List<CategoriaDestino> categoriasDisponiveis = destinoController.categoriasDisponiveis(); 
    destinoView.visualizarCategorias(categoriasDisponiveis);

    System.out.print("Escolha a Categoria: ");
    int opcao = scanner.nextInt();
    CategoriaDestino categoria = categoriasDisponiveis.get(opcao-1);
    Destino novoDestino = new Destino(nome, descricao, categoria);
    destinoController.adicionarDestino(novoDestino);

    System.out.println("Destino adicionado com sucesso!");
}

private static void editarDestino() {
    System.out.println("\n----- Editar Destino -----");

    if (destinoController.listarDestinos().isEmpty()) {
        System.out.println("Não há destinos para editar.");
        return;
    }

    System.out.println("Destinos Disponíveis:");
    List<IDestino> destinos = destinoController.listarDestinos();
    destinoView.visualizarDestinosDisponiveis(destinos);

    System.out.print("Escolha o número do Destino que deseja editar: ");
    int numeroDestino = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha após o número

    if (numeroDestino < 1 || numeroDestino > destinos.size()) {
        System.out.println("Número de destino inválido.");
        return;
    }

    IDestino destinoSelecionado = destinos.get(numeroDestino - 1);

    System.out.println("Opções de Edição para " + destinoSelecionado.getNome() + " - " + destinoSelecionado.getCategoria() + " :");
    System.out.println("1 - Alterar Descrição");
    System.out.println("0 - Voltar");

    System.out.print("Escolha uma opção: ");
    int opcaoEdicao = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha após o número

    switch (opcaoEdicao) {
        case 1:
            System.out.print("Nova Descrição: ");
            String novaDescricao = scanner.nextLine();
            destinoSelecionado.setDescricao(novaDescricao);
            System.out.println("Descrição alterada com sucesso!");
            break;
        case 0:
            System.out.println("Voltando ao Menu Gerenciar Destinos.");
            break;
        default:
            System.out.println("Opção inválida. Voltando ao Menu Gerenciar Destinos.");
    }
}

private static void removerDestino() {
    System.out.println("\n----- Remover Destino -----");

    if (destinoController.listarDestinos().isEmpty()) {
        System.out.println("Não há destinos para remover.");
        return;
    }

    System.out.println("Destinos Disponíveis:");
    List<IDestino> destinos = destinoController.listarDestinos();

    System.out.print("Escolha o número do Destino que deseja remover: ");
    int numeroDestino = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha após o número

    if (numeroDestino < 1 || numeroDestino > destinos.size()) {
        System.out.println("Número de destino inválido.");
        return;
    }

    IDestino destinoRemovido = destinos.get(numeroDestino - 1);
    destinoController.removerDestino(destinoRemovido);
    System.out.println("Destino \"" + destinoRemovido.getNome() + "\" removido com sucesso!");
}


private static void gerenciarPacotes() {
	int opcao;

    do {
        System.out.println("\n----- Gerenciar Pacotes -----");
        System.out.println("1 - Inserir Pacote");
        System.out.println("2 - Editar Pacote");
        System.out.println("3 - Remover Pacote");
        System.out.println("0 - Voltar ao Menu Administrativo");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o número

        switch (opcao) {
            case 1:
                inserirPacote();
                break;
            case 2:
                editarPacote();
                break;
            case 3:
                removerPacote();
                break;
            case 0:
                System.out.println("Voltando ao Menu Administrativo.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    } while (opcao != 0);
}


private static void inserirPacote() {
    System.out.println("\n----- Inserir Pacote -----");

    if (destinoController.listarDestinos().isEmpty()) {
        System.out.println("Não há destinos disponíveis para criar pacotes.");
        return;
    }

    System.out.println("Destinos Disponíveis:");
    
    List<IDestino> destinos = destinoController.listarDestinos();
    destinoView.visualizarDestinosDisponiveis(destinos);
    
    System.out.print("Escolha o número do Destino para o Pacote: ");
    
    int numeroDestino = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha após o número

    if (numeroDestino < 1 || numeroDestino > destinos.size()) {
        System.out.println("Número de destino inválido.");
        return;
    }

    IDestino destinoSelecionado = destinos.get(numeroDestino - 1);

    System.out.print("Digite o Preço do Pacote: ");
    
    double preco = scanner.nextDouble();
    scanner.nextLine(); // Consumir a quebra de linha após o número

    System.out.print("Data de Início do Pacote (DD/MM/AAAA): ");
    String dataInicioStr = scanner.nextLine();
    LocalDate dataInicio = converterStringParaData(dataInicioStr);

    System.out.print("Data de Fim do Pacote (DD/MM/AAAA): ");
    String dataFimStr = scanner.nextLine();
    LocalDate dataFim = converterStringParaData(dataFimStr);

    IPacoteViagem novoPacote = new PacoteViagem(destinoSelecionado, preco, dataInicio, dataFim);
    pacoteController.adicionarPacote(novoPacote);

    System.out.println("Pacote adicionado com sucesso!");
}

private static void editarPacote() {
    System.out.println("\n----- Editar Pacote -----");

    if (pacoteController.listarPacotes().isEmpty()) {
        System.out.println("Não há pacotes para editar.");
        return;
    }

    System.out.println("Pacotes Disponíveis:");
    List <IPacoteViagem> pacotes = pacoteController.listarPacotes();
    pacoteView.visualizarPacotesDisponiveis(pacotes);

    System.out.print("Escolha o número do Pacote que deseja editar: ");
    int numeroPacote = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha após o número

    if (numeroPacote < 1 || numeroPacote > pacotes.size()) {
        System.out.println("Número de pacote inválido.");
        return;
    }

    IPacoteViagem pacoteSelecionado = pacotes.get(numeroPacote - 1);

    System.out.println("Opções de Edição para o Pacote:");
    System.out.println("1 - Alterar Destino");
    System.out.println("2 - Alterar Data de Início");
    System.out.println("3 - Alterar Data de Fim");
    System.out.println("0 - Voltar");

    System.out.print("Escolha uma opção: ");
    int opcaoEdicao = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha após o número

    switch (opcaoEdicao) {
        case 1:
            System.out.println("Destinos Disponíveis:");
            List<IDestino> destinos = destinoController.listarDestinos();
            System.out.print("Escolha o número do Novo Destino para o Pacote: ");
            int numeroNovoDestino = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número

            if (numeroNovoDestino < 1 || numeroNovoDestino > destinos.size()) {
                System.out.println("Número de destino inválido.");
                return;
            }

            IDestino novoDestino = destinos.get(numeroNovoDestino - 1);
            pacoteSelecionado.setDestino(novoDestino);
            System.out.println("Destino do Pacote alterado com sucesso!");
            break;
        case 2:
            System.out.print("Nova Data de Início do Pacote (DD/MM/AAAA): ");
            String novaDataInicioStr = scanner.nextLine();
            LocalDate novaDataInicio = converterStringParaData(novaDataInicioStr);
            pacoteSelecionado.setDataInicio(novaDataInicio);
            System.out.println("Data de Início do Pacote alterada com sucesso!");
            break;
        case 3:
            System.out.print("Nova Data de Fim do Pacote (DD/MM/AAAA): ");
            String novaDataFimStr = scanner.nextLine();
            LocalDate novaDataFim = converterStringParaData(novaDataFimStr);
            pacoteSelecionado.setDataFim(novaDataFim);
            System.out.println("Data de Fim do Pacote alterada com sucesso!");
            break;
        case 0:
            System.out.println("Voltando ao Menu Gerenciar Pacotes.");
            break;
        default:
            System.out.println("Opção inválida. Voltando ao Menu Gerenciar Pacotes.");
    }
}

private static void removerPacote() {
    System.out.println("\n----- Remover Pacote -----");
    List<IPacoteViagem> pacotes = pacoteController.listarPacotes();
    if (pacotes.isEmpty()) {
        System.out.println("Não há pacotes para remover.");
        return;
    }

    System.out.println("Pacotes Disponíveis:");

    System.out.print("Escolha o número do Pacote que deseja remover: ");
    int numeroPacote = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha após o número

    if (numeroPacote < 1 || numeroPacote > pacotes.size()) {
        System.out.println("Número de pacote inválido.");
        return;
    }

    IPacoteViagem pacoteRemovido = pacotes.get(numeroPacote - 1);
    pacoteController.removerPacote(pacoteRemovido);
    System.out.println("Pacote removido com sucesso!");
}

private static void gerenciarUsuarios() {
    int opcao;

    do {
        System.out.println("\n----- Gerenciar Usuarios -----");
        System.out.println("1 - Inserir Usuario");
        System.out.println("2 - Remover Usuario");
        System.out.println("0 - Voltar ao Menu Administrativo");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o número

        switch (opcao) {
            case 1:
                inserirUsuario();
                break;
            case 2:
                removerUsuario();
                break;
            case 0:
                System.out.println("Voltando ao Menu Administrativo.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    } while (opcao != 0);
}

private static void inserirUsuario() {
	Map<String, IUsuario> usuarios = usuarioController.mapUsuarios();
    System.out.println("\n----- Cadastro -----");
    System.out.print("Digite seu nome: ");
    
    String nome = scanner.next();

    System.out.print("Digite uma email: ");
    String email = scanner.next();
    // Verifica se o Email já existe
    if (usuarios.containsKey(email)) {
        System.out.println("Email já existente. Tente um Email diferente.");
        return;
    }
    System.out.print("Repita o email: ");
    String repetirEmail = scanner.next();

    // Verifica se os emails coincidem
    if (!email.equals(repetirEmail)) {
        System.out.println("Os emails não coincidem. Por favor, corrija.");
        return;
    }
    //COMO DEVE SER
    //adicionarUsuario(nome,email);
    
    //COMO ESTA SENDO
    // Adiciona o novo usuário ao mapa
    Usuario usuario = new Usuario(nome,email);
    usuarios.put(email, usuario);

    System.out.println("Cadastro realizado com sucesso!");
}

private static void fazerCadastro() {
	inserirUsuario();
}


private static void removerUsuario() {
    System.out.println("\n----- Remover Usuario -----");
    Map<String,IUsuario> usuarios = usuarioController.mapUsuarios();

    if (usuarios.isEmpty()) {
        System.out.println("Não há usuarios para remover.");
        return;
    }

    System.out.print("Digite o Email do Usuario que deseja remover: ");
    String emailUsuario = scanner.nextLine();




    IUsuario usuarioRemovido = usuarios.remove(emailUsuario);

    if (usuarioRemovido != null) {
        System.out.println("Usuario \"" + usuarioRemovido.getNome() + "\" removido com sucesso!");
    } else {
        System.out.println("Não foi encontrado um usuario com o email informado.");
    }
}

private static LocalDate converterStringParaData(String dataStr) {
    try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataStr, formatter);
    } catch (Exception e) {
        System.out.println("Formato de data inválido. Use o formato DD/MM/AAAA.");
        return null;
    }
}
}
