import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Classe principal que contém o programa principal
// #1
public class carteiraVacina {
    private static Map<Integer, FichaPaciente> fichas = new HashMap<>();
    private static int proximoId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        // Loop principal que mantém o programa em execução até que o usuário escolha sair
        // #2
        do {
        	System.out.println();
            System.out.println("!!! SISTEMA DE CARTEIRA DE VACINAÇÃO !!!");
            System.out.println();
            System.out.println("1. Cadastro de Ficha");
            System.out.println("2. Visualizar Ficha");
            System.out.println("0. Sair");
            System.out.println();

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarFicha();
                    break;
                case 2:
                    visualizarFicha();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    
    // Método para cadastrar uma nova ficha de paciente
    // #3
    public static void cadastrarFicha() {

        System.out.println();
        System.out.println("== Preencha os dados do paciente ==");
        System.out.println();

        // Nome
        System.out.print("Nome do Paciente: ");
        String paciente = scanner.nextLine();
        // Data de Nascimento
        System.out.print("Data de nascimento: ");
        String nascimento = scanner.nextLine();
        // CPF
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.println();
 
        List<Vacina> vacinas = new ArrayList<>();
        boolean adicionarMaisVacinas = true;
        while (adicionarMaisVacinas) {
            System.out.println();
            System.out.print("Nome da vacina: ");
            String nomeVacina = scanner.nextLine();
            System.out.print("Data de vacinação (DD/MM/AAAA): ");
            String dataVacina = scanner.nextLine();
            System.out.print("Número de doses: ");
            int numDoses = scanner.nextInt();
            scanner.nextLine();

            Vacina vacina = new Vacina(nomeVacina, dataVacina, numDoses);
            vacinas.add(vacina);
            
            System.out.println();
            System.out.print("Deseja adicionar mais vacinas? (S/N): ");
            String resposta = scanner.nextLine();
            adicionarMaisVacinas = resposta.equalsIgnoreCase("S");
        }

        FichaPaciente ficha = new FichaPaciente(proximoId, paciente, nascimento, cpf, vacinas);
        fichas.put(proximoId, ficha);
        proximoId++;
        System.out.println();
        System.out.println("Ficha cadastrada com sucesso! ID do paciente: " + ficha.getId());
        System.out.println();
    }
    
    // Método para visualizar a ficha de um paciente
    public static void visualizarFicha() {
        System.out.print("Digite o ID do paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        FichaPaciente ficha = fichas.get(id);
        if (ficha != null) {
        	System.out.println();
            System.out.println("Ficha do paciente ID " + id + ":");
            System.out.println();
            System.out.println("Nome do Paciente: " + ficha.getPaciente());
            System.out.println("Data de Nascimento: " + ficha.getNascimento());
            System.out.println("CPF: " + ficha.getCpf());
            System.out.println();
            System.out.println("Vacinas Aplicadas:");
            for (Vacina vacina : ficha.getVacinas()) {
                System.out.println("  - " + vacina.getNome());
                System.out.println("  Data de Vacinação: " + vacina.getDataVacina());
                System.out.println("  Número de Doses: " + vacina.getNumDoses());
            }
        } else {
            System.out.println("Paciente não encontrado com o ID fornecido.");
        }
    }
}

//Classe que representa uma ficha de paciente
class FichaPaciente {
    private int id;
    private String paciente;
    private String nascimento;
    private String cpf;
    private List<Vacina> vacinas;

    public FichaPaciente(int id, String paciente, String nascimento, String cpf, List<Vacina> vacinas) {
        this.id = id;
        this.paciente = paciente;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.vacinas = vacinas;
    }

    public int getId() {
        return id;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }
}

class Vacina {
    private String nome;
    private String dataVacina;
    private int numDoses;

    public Vacina(String nome, String dataVacina, int numDoses) {
        this.nome = nome;
        this.dataVacina = dataVacina;
        this.numDoses = numDoses;
    }

    public String getNome() {
        return nome;
    }

    public String getDataVacina() {
        return dataVacina;
    }

    public int getNumDoses() {
        return numDoses;
    }
}
