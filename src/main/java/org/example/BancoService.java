package org.example;

import java.util.HashMap;
import java.util.Map;

public class BancoService {
    private Map<String, Conta> contas; // Usa um HashMap para associar titular à conta

    public BancoService() {
        this.contas = new HashMap<>();
    }

    public void criarConta(String titular, double saldoInicial) {
        Conta conta = new Conta(titular, saldoInicial);
        contas.put(titular, conta);
        System.out.println("Conta criada para " + titular);
    }

    public void transferir(String origem, String destino, double valor) {
        Conta contaOrigem = contas.get(origem);
        Conta contaDestino = contas.get(destino);

        if (contaOrigem != null && contaDestino != null && contaOrigem.sacar(valor)) {
            contaDestino.depositar(valor);
            System.out.println("Transferência de " + valor + " realizada de " + origem + " para " + destino);
        } else {
            System.out.println("Erro na transferência.");
        }
    }

    public void exibirSaldo(String titular) {
        Conta conta = contas.get(titular);
        if (conta != null) {
            System.out.println("Saldo de " + titular + ": R$" + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
}