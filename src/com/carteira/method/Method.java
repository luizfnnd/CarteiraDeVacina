package com.carteira.method;
import java.util.*;

import com.carteira.model.FichaPaciente;
import com.carteira.model.Vacina;

public class Method {
    private static Scanner scanner = new Scanner(System.in);
    private static int proxId = 1;
    private static Map<Integer, FichaPaciente> fichas = new HashMap<>();

    public static void cadastrarFicha() {
        System.out.println();
        System.out.println("> Preencha os dados do paciente <");
        System.out.println();

        // Nome
        System.out.print("Nome do Paciente: ");
        String nome = scanner.nextLine();
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
        FichaPaciente ficha = new FichaPaciente(proxId, nome, nascimento, cpf, vacinas);
        fichas.put(proxId, ficha);
        proxId++;
        System.out.println();
        System.out.println("Ficha cadastrada com sucesso! ID do paciente: " + ficha.getId());
        System.out.println();
    }

    public static void visualizarFicha() {
        System.out.print("Digite o ID do paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        FichaPaciente ficha = fichas.get(id);
        if (ficha != null) {
            System.out.println();
            System.out.println("Ficha do paciente ID " + id + ":");
            System.out.println();
            System.out.println("Nome do Paciente: " + ficha.getNome());
            System.out.println("Data de Nascimento: " + ficha.getDtNascimento());
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
    public static void listarFicha () {
        System.out.println("> Lista de Fichas Cadastradas <");
        for (FichaPaciente ficha : fichas.values()) {
            System.out.println(ficha.getId() + " - " + ficha.getNome());
        }
    }
}
