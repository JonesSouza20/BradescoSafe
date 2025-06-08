package Projeto.Golpista;

import java.util.Date;

public class CriarConta {
    String cpf;
    String RG;
    String endereco;
    String nomeCompleto;
    Date dataNascimento;

    private CriarConta(String cpf, String rg, String endereco, String nomeCompleto, Date dataNascimento) {
        this.cpf = cpf;
        this.RG = rg;
        this.endereco = endereco;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRG() {
        return RG;
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

    public void setCpf() {
        this.cpf = cpf;
    }

    public void setRG() {
        this.RG = RG;
    }

    public void setEndereco() {
        this.endereco = endereco;
    }

    public void setNomeCompleto() {
        this.nomeCompleto = nomeCompleto;
    }

    public void setDataNascimento() {
        this.dataNascimento = dataNascimento;
    }

    public class Endereco {
        int cep;
        String Rua;
        int numero;
        String cidade;
        String estado;
        String complemento;
    }

    public class Cpf {
        String cpf;
    }

    public class Rg {
        String Rg;
    }

    public class NomeCompleto {
        String nomeCompleto;
    }

    public enum DataNascimento {
        JANEIRO, FEVEREIRO, MARCO, ABRIL, MAIO, JUNHO,
        JULHO, AGOSTO, SETEMBRO, OUTUBRO, NOVEMBRO, DEZEMBRO;
    }

}