package com.carteira;
import java.util.Scanner;
import com.carteira.method.Method;



public class Main {
    public static void main(String[] args) {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("Sistema de Carteira de Vacinação");
            System.out.println("1. Cadastro de Ficha");
            System.out.println("2. Listar Fichas");
            System.out.println("3. Visualizar Ficha");
            System.out.println("0. Sair do Programa");
            System.out.println();

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    Method.cadastrarFicha();
                    break;
                case 2:
                    Method.listarFicha();
                    break;
                case 3:
                    Method.visualizarFicha();
                    break;
                case 0:
                    System.out.println("Saindo do Programa...");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        } while (opcao != 0);
    }
}