package br.com.a3bradesco.projeto.model;

public class Conta {
    private String numeroConta;
    private String senha;

    public Conta(String numeroConta, String senha) {
        this.numeroConta = numeroConta;
        this.senha = senha;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getSenha() {
        return senha;
    }
}
