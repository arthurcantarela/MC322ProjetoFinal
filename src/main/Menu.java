package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import model.*;
import controller.*;
import exceptions.CampoVazioException;
import exceptions.EmailExistenteException;
import exceptions.EmailsNaoCoincidemException;
import exceptions.FormatoDataInvalidoException;
import exceptions.IntervaloDatasInvalidoException;
import exceptions.OpcaoInvalidaException;
import exceptions.PrecoInvalidoException;
import exceptions.ReservaIndisponivelException;
import exceptions.TenteNovamenteException;
import view.*;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    public static List<PacoteViagem> pacotes = new ArrayList<>();
    public static IPacoteView pacoteView = new PacoteView();
    public static IDestinoView destinoView = new DestinoView();
    public static IUsuarioView usuarioView = new UsuarioView();
    public static IReservaView reservaView = new ReservaView();
    public static IPacoteController pacoteController = new PacoteController();
    public static IDestinoController destinoController = new DestinoController();
    public static IReservaController reservaController = new ReservaController();
    public static IUsuarioController usuarioController = new UsuarioController();

    private static IUsuario usuarioLogado;

    public static void main(String[] args) {
        scanner.useDelimiter("\n");
        int opcao;

        do {
            System.out.println("\n----- Menu -----");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = -1;
                scanner.nextLine();
            }

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
                if (usuarioLogado instanceof UsuarioAdmin) {
                    menuOpcoesAdministrativas();
                } else {
                    menuOpcoesUsuario();
                }
                usuarioLogado = null;
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void fazerLogin() {
        System.out.print("Digite o email: ");
        Map<String, IUsuario> usuarios = usuarioController.mapUsuarios();
        String email = scanner.next();

        IUsuario usuario = usuarios.get(email);

        if (usuario != null) {
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
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = -1;
                scanner.nextLine();
            }

            switch (opcao) {
                case 1:
                    procurarPacote();
                    break;
                case 2:
                    visualizarReservas();
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
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = -1;
                scanner.nextLine();
            }

            try {
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
            } catch (TenteNovamenteException e) {
                System.out.println(e.getMessage());
            }

        } while (opcao != 0);
    }

    private static void procurarPorDestino() {
        System.out.println("\n----- Procurar por Destino -----");
        System.out.println("1 - Visualizar Destinos Disponíveis");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao;
        try {
            opcao = scanner.nextInt();
        } catch (InputMismatchException e) {
            opcao = -1;
            scanner.nextLine();
        }

        try {
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
        } catch (TenteNovamenteException e) {
            System.out.println(e.getMessage());
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
        int opcao;
        try {
            opcao = scanner.nextInt();
        } catch (InputMismatchException e) {
            opcao = -1;
            scanner.nextLine();
        }

        try {
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
        } catch (TenteNovamenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void visualizarDestinosDisponiveisMenu() throws TenteNovamenteException {
        List<IDestino> destinosDisponiveis = destinoController.destinosDisponiveis(pacoteController);

        System.out.println("\n--- Destinos Disponíveis ---");

        destinoView.visualizarDestinos(destinosDisponiveis);

        System.out.println("Escolha o destino desejado: ");

        int opcao;

        try {
            opcao = scanner.nextInt();
        } catch (InputMismatchException e) {
            opcao = -1;
            scanner.nextLine();
        }

        try {
            IDestino destinoSelecionado = destinosDisponiveis.get(opcao - 1);
            List<IPacoteViagem> pacotesDisponiveis = pacoteController.buscarPacotesDisponiveis(destinoSelecionado);

            System.out.println("\n--- Pacotes Disponíveis - Destino " + destinoSelecionado.getNome() + " ---");

            pacoteView.visualizarPacotes(pacotesDisponiveis);

            System.out.println("Selecione um Pacote para Reserva (ou volte ao Menu selecionando 0)");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = -1;
                scanner.nextLine();
            }

            if (opcao == 0) {
                System.out.println("Retornando ao Menu...");
                return;
            }

            IPacoteViagem pacoteSelecionado = pacotesDisponiveis.get(opcao - 1);

            if (opcao != 0) {
                try {
                    reservaController.reservarPacote(usuarioLogado, pacoteSelecionado);
                    System.out.println("Pacote para o usuário " + usuarioLogado + " com destino a "
                            + pacotesDisponiveis.get(opcao - 1).getDestino().getNome() + " reservado com sucesso!");
                } catch (ReservaIndisponivelException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        } catch (IndexOutOfBoundsException e) {
            throw new OpcaoInvalidaException();
        }
    }

    private static void procurarPorPrecoMaximo() throws TenteNovamenteException {
        System.out.print("Digite o preço máximo desejado: ");
        double precoMaximo;
        try {
            precoMaximo = scanner.nextDouble();
            if (precoMaximo < 0) {
                throw new PrecoInvalidoException();

            }
        } catch (InputMismatchException e) {
            throw new PrecoInvalidoException();
        }
        List<IPacoteViagem> pacotesDisponiveis = pacoteController.buscarPacotesDisponiveis(precoMaximo);

        System.out.println("\n--- Pacotes Disponíveis - Preço Máximo " + precoMaximo + " ---");

        pacoteView.visualizarPacotes(pacotesDisponiveis);

        System.out.println("Selecione um Pacote para Reserva (ou volte ao Menu selecionando 0)");

        int opcao;

        try {
            opcao = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new OpcaoInvalidaException();
        }

        if (opcao == 0) {
            System.out.println("Retornando ao Menu...");
            return;
        }

        try {
            IPacoteViagem pacoteSelecionado = pacotesDisponiveis.get(opcao - 1);
            if (opcao != 0) {
                try {
                    reservaController.reservarPacote(usuarioLogado, pacoteSelecionado);
                    System.out.println("Pacote para o usuário " + usuarioLogado + " com destino a "
                            + pacotesDisponiveis.get(opcao - 1).getDestino().getNome() + " reservado com sucesso!");
                } catch (ReservaIndisponivelException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (

        IndexOutOfBoundsException e) {
            throw new OpcaoInvalidaException();
        }

    }

    private static void exibirPacotesPorCategoria(CategoriaDestino categoria) throws OpcaoInvalidaException {

        List<IPacoteViagem> pacotesDisponiveis = pacoteController.buscarPacotesDisponiveis(categoria);

        System.out.println("\n--- Pacotes Disponíveis - Categoria " + categoria + " ---");

        pacoteView.visualizarPacotes(pacotesDisponiveis);

        System.out.println("Selecione um Pacote para Reserva (ou volte ao Menu selecionando 0)");

        int opcao;

        try {
            opcao = scanner.nextInt();
        } catch (InputMismatchException e) {
            opcao = -1;
            scanner.nextLine();
        }

        if (opcao == 0) {
            System.out.println("Retornando ao Menu...");
            return;
        }

        try {
            IPacoteViagem pacoteSelecionado = pacotesDisponiveis.get(opcao - 1);
            if (opcao != 0) {
                try {
                    reservaController.reservarPacote(usuarioLogado, pacoteSelecionado);
                    System.out.println("Pacote para o usuário " + usuarioLogado + " com destino a "
                            + pacotesDisponiveis.get(opcao - 1).getDestino().getNome() + " reservado com sucesso!");
                } catch (ReservaIndisponivelException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (IndexOutOfBoundsException e) {
            throw new OpcaoInvalidaException();
        }
    }

    private static void visualizarReservas() {
        System.out.println("\n----- Mostrando Reservas de " + usuarioLogado.getNome() + "-----");
        reservaView.visualizarReservas(reservaController.listarReservasUsuario(usuarioLogado));
    }

    public static void menuOpcoesAdministrativas() {
        int escolha;
        do {
            exibirMenu();
            // Ler a escolha do usuário
            try {
                escolha = scanner.nextInt();
            } catch (InputMismatchException e) {
                escolha = -1;
                scanner.nextLine();
            }
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
        } while (escolha != 0);

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
            System.out.println("1 - Visualizar Destinos");
            System.out.println("2 - Inserir Destino");
            System.out.println("3 - Editar Destino");
            System.out.println("4 - Remover Destino");
            System.out.println("0 - Voltar ao Menu Administrativo");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = -1;
                scanner.nextLine();
            }
            scanner.nextLine(); // Consumir a quebra de linha após o número

            try {
                switch (opcao) {
                    case 1:
                        visualizarDestino();
                        break;
                    case 2:
                        inserirDestino();
                        break;
                    case 3:
                        editarDestino();
                        break;
                    case 4:
                        removerDestino();
                        break;
                    case 0:
                        System.out.println("Voltando ao Menu Administrativo.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (TenteNovamenteException e) {
                System.out.println(e.getMessage());
            }
        } while (opcao != 0);
    }

    private static void visualizarDestino() {
        destinoView.visualizarDestinos(destinoController.listarDestinos());
    }

    private static void inserirDestino() throws TenteNovamenteException {
        System.out.println("\n----- Inserir Destino -----");

        System.out.print("Nome do Destino: ");
        String nome = scanner.nextLine();
        if (nome.isBlank()) {
            throw new CampoVazioException("nome");
        }

        System.out.print("Descrição do Destino: ");
        String descricao = scanner.nextLine();
        if (descricao.isBlank()) {
            throw new CampoVazioException("descricao");
        }

        System.out.println("Categorias Disponíveis:");
        List<CategoriaDestino> categoriasDisponiveis = destinoController.categoriasDisponiveis();
        destinoView.visualizarCategorias(categoriasDisponiveis);

        System.out.print("Escolha a Categoria: ");
        int opcao;

        try {
            opcao = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new OpcaoInvalidaException();
        }

        try {
            CategoriaDestino categoria = categoriasDisponiveis.get(opcao - 1);
            Destino novoDestino = new Destino(nome, descricao, categoria);
            destinoController.adicionarDestino(novoDestino);

            System.out.println("Destino adicionado com sucesso!");
        } catch (IndexOutOfBoundsException e) {
            throw new OpcaoInvalidaException();
        }

    }

    private static void editarDestino() {
        System.out.println("\n----- Editar Destino -----");

        if (destinoController.listarDestinos().isEmpty()) {
            System.out.println("Não há destinos para editar.");
            return;
        }

        System.out.println("Destinos Disponíveis:");
        List<IDestino> destinos = destinoController.listarDestinos();
        destinoView.visualizarDestinos(destinos);

        System.out.print("Escolha o número do Destino que deseja editar: ");
        int numeroDestino;

        try {
            numeroDestino = scanner.nextInt();
        } catch (InputMismatchException e) {
            numeroDestino = -1;
            scanner.nextLine();
        }

        scanner.nextLine(); // Consumir a quebra de linha após o número

        if (numeroDestino < 1 || numeroDestino > destinos.size()) {
            System.out.println("Número de destino inválido.");
            return;
        }

        IDestino destinoSelecionado = destinos.get(numeroDestino - 1);

        System.out.println("Opções de Edição para " + destinoSelecionado.getNome() + " - "
                + destinoSelecionado.getCategoria() + " :");
        System.out.println("1 - Alterar Descrição");
        System.out.println("0 - Voltar");

        System.out.print("Escolha uma opção: ");
        int opcaoEdicao;

        try {
            opcaoEdicao = scanner.nextInt();
        } catch (InputMismatchException e) {
            opcaoEdicao = -1;
            scanner.nextLine();
        }

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
        destinoView.visualizarDestinos(destinos);

        System.out.print("Escolha o número do Destino que deseja remover: ");
        int numeroDestino;

        try {
            numeroDestino = scanner.nextInt();
        } catch (InputMismatchException e) {
            numeroDestino = -1;
            scanner.nextLine();
        }

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
            System.out.println("1 - Visualizar Pacotes");
            System.out.println("2 - Inserir Pacote");
            System.out.println("3 - Editar Pacote");
            System.out.println("4 - Remover Pacote");
            System.out.println("0 - Voltar ao Menu Administrativo");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = -1;
                scanner.nextLine();
            }

            scanner.nextLine(); // Consumir a quebra de linha após o número

            try {
                switch (opcao) {
                    case 1:
                        visualizarPacotes();
                        break;
                    case 2:
                        inserirPacote();
                        break;
                    case 3:
                        editarPacote();
                        break;
                    case 4:
                        removerPacote();
                        break;
                    case 0:
                        System.out.println("Voltando ao Menu Administrativo.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (TenteNovamenteException e) {
                System.out.println(e.getMessage());
            }
        } while (opcao != 0);
    }

    private static void visualizarPacotes() {
        pacoteView.visualizarPacotes(pacoteController.listarPacotes());
    }

    private static void inserirPacote() throws TenteNovamenteException {
        System.out.println("\n----- Inserir Pacote -----");

        if (destinoController.listarDestinos().isEmpty()) {
            System.out.println("Não há destinos disponíveis para criar pacotes.");
            return;
        }

        System.out.println("Destinos Disponíveis:");

        List<IDestino> destinos = destinoController.listarDestinos();
        destinoView.visualizarDestinos(destinos);

        System.out.print("Escolha o número do Destino para o Pacote: ");

        int numeroDestino;

        try {
            numeroDestino = scanner.nextInt();
        } catch (InputMismatchException e) {
            numeroDestino = -1;
            scanner.nextLine();
        }

        scanner.nextLine(); // Consumir a quebra de linha após o número

        if (numeroDestino < 1 || numeroDestino > destinos.size()) {
            System.out.println("Número de destino inválido.");
            return;
        }

        IDestino destinoSelecionado = destinos.get(numeroDestino - 1);

        System.out.print("Digite o Preço do Pacote: ");

        double preco;
        try {
            preco = scanner.nextDouble();
            if (preco < 0) {
                throw new PrecoInvalidoException();
            }
        } catch (InputMismatchException e) {
            throw new PrecoInvalidoException();

        }
        scanner.nextLine(); // Consumir a quebra de linha após o número

        System.out.print("Data de Início do Pacote (DD/MM/AAAA): ");
        String dataInicioStr = scanner.nextLine();
        LocalDate dataInicio = converterStringParaData(dataInicioStr);

        System.out.print("Data de Fim do Pacote (DD/MM/AAAA): ");
        String dataFimStr = scanner.nextLine();
        LocalDate dataFim = converterStringParaData(dataFimStr);

        if (!dataInicio.isBefore(dataFim)) {
            throw new IntervaloDatasInvalidoException();
        }

        IPacoteViagem novoPacote = new PacoteViagem(destinoSelecionado, preco, dataInicio, dataFim);
        pacoteController.adicionarPacote(novoPacote);

        System.out.println("Pacote adicionado com sucesso!");
    }

    private static void editarPacote() throws TenteNovamenteException {
        System.out.println("\n----- Editar Pacote -----");

        if (pacoteController.listarPacotes().isEmpty()) {
            System.out.println("Não há pacotes para editar.");
            return;
        }

        System.out.println("Pacotes Disponíveis:");
        List<IPacoteViagem> pacotes = pacoteController.listarPacotes();
        pacoteView.visualizarPacotes(pacotes);

        System.out.print("Escolha o número do Pacote que deseja editar: ");
        int numeroPacote;

        try {
            numeroPacote = scanner.nextInt();
        } catch (InputMismatchException e) {
            numeroPacote = -1;
            scanner.nextLine();
        }
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
        int opcaoEdicao;

        try {
            opcaoEdicao = scanner.nextInt();
        } catch (InputMismatchException e) {
            opcaoEdicao = -1;
            scanner.nextLine();
        }
        scanner.nextLine(); // Consumir a quebra de linha após o número

        switch (opcaoEdicao) {
            case 1:
                System.out.println("Destinos Disponíveis:");
                List<IDestino> destinos = destinoController.listarDestinos();
                System.out.print("Escolha o número do Novo Destino para o Pacote: ");
                int numeroNovoDestino;

                try {
                    numeroNovoDestino = scanner.nextInt();
                } catch (InputMismatchException e) {
                    numeroNovoDestino = -1;
                    scanner.nextLine();
                }
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
                if (!novaDataInicio.isBefore(pacoteSelecionado.getDataFim())) {
                    throw new IntervaloDatasInvalidoException();
                }
                pacoteSelecionado.setDataInicio(novaDataInicio);
                System.out.println("Data de Início do Pacote alterada com sucesso!");
                break;
            case 3:
                System.out.print("Nova Data de Fim do Pacote (DD/MM/AAAA): ");
                String novaDataFimStr = scanner.nextLine();
                LocalDate novaDataFim = converterStringParaData(novaDataFimStr);
                if (!pacoteSelecionado.getDataInicio().isBefore(novaDataFim)) {
                    throw new IntervaloDatasInvalidoException();
                }
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
        int numeroPacote;

        try {
            numeroPacote = scanner.nextInt();
        } catch (InputMismatchException e) {
            numeroPacote = -1;
            scanner.nextLine();
        }

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
            System.out.println("1 - Visualizar Usuarios");
            System.out.println("2 - Inserir Usuario");
            System.out.println("3 - Remover Usuario");
            System.out.println("4 - Tornar Administrador");
            System.out.println("0 - Voltar ao Menu Administrativo");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = -1;
                scanner.nextLine();
            }

            scanner.nextLine(); // Consumir a quebra de linha após o número

            switch (opcao) {
                case 1:
                    visualizarUsuarios();
                    break;
                case 2:
                    fazerCadastro();
                    break;
                case 3:
                    removerUsuario();
                    break;
                case 4:
                    tornarAdmin();
                case 0:
                    System.out.println("Voltando ao Menu Administrativo.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void visualizarUsuarios() {
        usuarioView.visualizarUsuarios(usuarioController.listarUsuarios());
    }

    private static void inserirUsuario()
            throws TenteNovamenteException {
        Map<String, IUsuario> usuarios = usuarioController.mapUsuarios();
        System.out.println("\n----- Cadastro -----");
        System.out.print("Digite seu nome: ");

        String nome = scanner.next();
        if (nome.isBlank()) {
            throw new CampoVazioException("nome");
        }

        System.out.print("Digite uma email: ");
        String email = scanner.next();
        if (email.isBlank()) {
            throw new CampoVazioException("email");
        }

        // Verifica se o Email já existe
        if (usuarios.containsKey(email)) {
            throw new EmailExistenteException();
        }
        System.out.print("Repita o email: ");
        String repetirEmail = scanner.next();

        // Verifica se os emails coincidem
        if (!email.equals(repetirEmail)) {
            throw new EmailsNaoCoincidemException();
        }

        IUsuario novoUsuario = usuarioController.adicionarUsuario(nome, email);
        System.out.println("Usuario " + novoUsuario.getNome() + " cadastrado com sucesso!");
    }

    private static void fazerCadastro() {
        try {
            inserirUsuario();
        } catch (TenteNovamenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removerUsuario() {
        System.out.println("\n----- Remover Usuario -----");
        Map<String, IUsuario> usuarios = usuarioController.mapUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("Não há usuarios para remover.");
            return;
        }

        System.out.print("Digite o Email do Usuario que deseja remover: ");
        String emailUsuario = scanner.nextLine();

        IUsuario usuarioRemovido = usuarioController.removerUsuario(emailUsuario);

        if (usuarioRemovido != null) {
            System.out.println("Usuario \"" + usuarioRemovido.getNome() + "\" removido com sucesso!");
        } else {
            System.out.println("Não foi encontrado um usuario com o email informado.");
        }
    }

    private static void tornarAdmin() {
        System.out.println("\n----- Tornar Usuario Administrador-----");
        System.out.print("Digite o Email do Usuario que deseja tornar Administrador: ");
        String emailUsuario = scanner.nextLine();

        IUsuario novoAdmin = usuarioController
                .adicionarUsuario(new UsuarioAdmin(usuarioController.removerUsuario(emailUsuario)));

        System.out.print("Usuario Administrador: " + novoAdmin.getNome() + " registrado com sucesso!");

    }

    private static LocalDate converterStringParaData(String dataStr) throws FormatoDataInvalidoException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dataStr, formatter);
        } catch (DateTimeParseException e) {
            throw new FormatoDataInvalidoException();
        }
    }
}
