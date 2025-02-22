package org.example;

import java.util.UUID;

public class Conta {

    private String id;
    private String titular;
    private double saldo;

    public Conta(String titular, double saldoInicial) {
        this.id = UUID.randomUUID().toString(); // Gera um identificador único
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}
