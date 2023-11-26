package ui;


import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import model.PacoteViagem;
import model.Destino;
import model.IDestino;
import model.CategoriaDestino;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, String> usuarios = new HashMap<>();
    //private static final Map<String, IUsuario> usuarios = new HashMap<>();
    public static List<PacoteViagem> pacotes = new ArrayList<>();
    
    //private static final List<Reserva> reservas = new ArrayList<>();
    private static String usuarioLogado;    
    
    public static void main(String[] args) {
        // Adicionando um usuário de exemplo (admin)
        usuarios.put("admin", "senhaAdmin");
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
                if (usuarioLogado.equals("admin")) {
                    //menuOpcoesAdministrativas();
                } else {
                    menuOpcoesUsuario();
                }
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void fazerLogin() {
        System.out.print("Digite o usuário: ");
        String usuario = scanner.next();
        System.out.print("Digite a senha: ");
        String senha = scanner.next();

        if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(senha)) {
            System.out.println("Login bem-sucedido!");

            // Define o usuário logado
            usuarioLogado = usuario;
        } else {
            System.out.println("Usuário ou senha incorretos. Acesso negado.");
        }
    }

    private static void fazerCadastro() {
        System.out.println("\n----- Cadastro -----");
        System.out.print("Digite um usuário: ");
        String usuario = scanner.next();

        // Verifica se o usuário já existe
        if (usuarios.containsKey(usuario)) {
            System.out.println("Usuário já existente. Tente um usuário diferente.");
            return;
        }

        System.out.print("Digite uma senha: ");
        String senha = scanner.next();
        System.out.print("Repita a senha: ");
        String repetirSenha = scanner.next();

        // Verifica se as senhas coincidem
        if (!senha.equals(repetirSenha)) {
            System.out.println("As senhas não coincidem. Por favor, corrija.");
            return;
        }

        System.out.print("Digite um email: ");
        String email = scanner.next();

        // Adiciona o novo usuário ao mapa
        usuarios.put(usuario, senha);

        System.out.println("Cadastro realizado com sucesso!");
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
                visualizarDestinosDisponiveis();
                break;
           // case 2:
           //     inserirDestino();
           //     break;
            case 0:
                System.out.println("Voltando à busca por pacote.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void visualizarDestinosDisponiveis() {
        // Adicione aqui a lógica para exibir destinos disponíveis
        // ...

        // Exemplo de exibição de destinos disponíveis
        System.out.println("\n--- Destinos Disponíveis ---");
        int i = 0;
        int j = 0;
        Set<Destino> destinosExibidos = new HashSet<>();
        List<String> listaAux = new ArrayList<>();
        List<PacoteViagem> pacoteSel = new ArrayList<>();
        for (PacoteViagem pacote : pacotes) {
        	if(pacote.isDisponivel() && destinosExibidos.add(pacote.getDestino())) {
        		listaAux.add(i, pacote.getDestino().getNome());
        		i ++;
        		System.out.println(i+ "- " + pacote.getDestino().getNome());
        	}
        }
        System.out.println("Escolha o destino desejado: ");
        
        int opcao = scanner.nextInt();
        
        System.out.println("\n--- Pacotes Disponíveis - Destino " + listaAux.get(opcao-1) + " ---");
        for (PacoteViagem pacote : pacotes) {
            if (pacote.getDestino().getNome().equals(listaAux.get(opcao-1)) && pacote.isDisponivel()) {
            	j++;
            	System.out.println("Pacote " + j + ": ");
            	imprimirPacote(pacote);
            	pacoteSel.add(pacote);
            }
        }
        oferecerReserva(pacoteSel);
    }
        
        
    
    private static void oferecerReserva(List<PacoteViagem> pacotesSel) {
    	
    	System.out.println("Selecione um Pacote para Reserva (ou volte ao Menu selecionando 0)");
        int opcao = scanner.nextInt();
        if(opcao != 0) {
        	//reservaPacote(pacotesSel.get(opcao-1));
        	System.out.println("Pacote para o usuário " + usuarioLogado + " com destino a " + pacotesSel.get(opcao-1).getDestino().getNome() + " reservado com sucesso!");
        } 
        return;
    }
    
    private static void imprimirPacote(PacoteViagem pacote) {
    	System.out.println("Categoria: " + pacote.getDestino().getCategoria());
        System.out.println("Destino: " + pacote.getDestino().getNome());
        System.out.println("Preço: R$ " + pacote.getPreco());
        System.out.println("Data de Início: " + pacote.getDataInicio());
        System.out.println("Data de Fim: " + pacote.getDataFim());
        System.out.println();
    }
        // ...
    

//    private static void inserirDestino() {
//        System.out.print("Digite o destino desejado: ");
//        String destino = scanner.next();
//
//        // Adicione aqui a lógica para inserir um novo destino
//        // ...
//        System.out.println("Buscando destino ...");
//        if(pacotes.)
//        System.out.println("\n--- Pacotes Disponíveis - Destino " + destino + " ---");
//        for (PacoteViagem pacote : pacotes) {
//            if (pacote.getDestino().getNome().equals(destino)) {
//                System.out.println("Categoria: " + pacote.getCategoria());
//                System.out.println("Destino: " + pacote.getDestino().getNome());
//                System.out.println("Preço: R$ " + pacote.getPreco());
//                System.out.println("Data de Início: " + pacote.getDataInicio());
//                System.out.println("Data de Fim: " + pacote.getDataFim());
//                System.out.println();
//            }
//        }
//        //buscarDestinoCadastrado();
//        
//    }

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
                exibirPacotesPorCategoria(CategoriaDestino.PRAIA);
                exibirPacotesPorCategoria(CategoriaDestino.MONTANHA);
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

    private static void procurarPorPrecoMaximo() {
        System.out.print("Digite o preço máximo desejado: ");
        double precoMaximo = scanner.nextDouble();
        int j = 0;
        List<PacoteViagem> pacoteSel = new ArrayList<>();
        
        System.out.println("\n--- Pacotes Disponíveis - Preço Máximo " + precoMaximo + " ---");
        for (PacoteViagem pacote : pacotes) {
            if (pacote.getPreco() <= precoMaximo && pacote.isDisponivel()) {
            	j++;
            	System.out.println("Pacote " + j + ": ");
            	imprimirPacote(pacote);
            	pacoteSel.add(pacote);
            }
        }
        oferecerReserva(pacoteSel);

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

//    private static void visualizarReservas() {
//        System.out.println("\n----- Suas Reservas -----");
//        for (Reserva reserva : reservas) {
//            if (reserva.getUsuario().equals(usuarioLogado)) {
//                System.out.println("Reserva " + reserva.getId() + ":");
//                System.out.println("Categoria: " + reserva.getCategoria());
//                System.out.println("Destino: " + reserva.getDestino());
//                System.out.println("Preço: R$ " + reserva.getPreco());
//                System.out.println("Data de Início: " + reserva.getDataInicio());
//                System.out.println("Data de Fim: " + reserva.getDataFim());
//                System.out.println();
//            }
//        }
//
//        // Adicione aqui a lógica para permitir que o usuário altere ou desista das reservas
//        // ...
//    }

    private static void exibirPacotesPorCategoria(CategoriaDestino categoria) {
    	int j = 0;
        List<PacoteViagem> pacoteSel = new ArrayList<>();
        
        System.out.println("\n--- Pacotes Disponíveis - Categoria " + categoria + " ---");
        for (PacoteViagem pacote : pacotes) {
            if (pacote.getDestino().getCategoria().equals(categoria) && pacote.isDisponivel()) {
            	j++;
            	System.out.println("Pacote " + j + ": ");
            	imprimirPacote(pacote);
            	pacoteSel.add(pacote);
            }
        }
        oferecerReserva(pacoteSel);
   }
        
    
}