package br.com.a3bradesco.golpista;

import java.util.Date;

public class CriarConta {
    private String cpf;
    private String rg;
    private String endereco;
    private String nomeCompleto;
    private Date dataNascimento;

    public CriarConta(String cpf, String rg, String endereco, String nomeCompleto, Date dataNascimento) {
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
