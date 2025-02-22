package org.example;

import java.util.Scanner;

public class BancoApp {

    public static void main(String[] args) {
        BancoService bancoService = new BancoService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Criar conta\n2. Transferir\n3. Consultar saldo\n4. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do titular: ");
                    String nome = scanner.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldo = scanner.nextDouble();
                    bancoService.criarConta(nome, saldo);
                    break;
                case 2:
                    System.out.print("Titular origem: ");
                    String origem = scanner.nextLine();
                    System.out.print("Titular destino: ");
                    String destino = scanner.nextLine();
                    System.out.print("Valor: ");
                    double valor = scanner.nextDouble();
                    bancoService.transferir(origem, destino, valor);
                    break;
                case 3:
                    System.out.print("Nome do titular: ");
                    String titular = scanner.nextLine();
                    bancoService.exibirSaldo(titular);
                    break;
                case 4:
                    System.out.println("Encerrando...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
