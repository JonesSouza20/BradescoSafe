package Projeto.Golpista;
import java.util.Scanner;

public class SolicitarEmprestimo {

    Scanner sc = new Scanner (System.in);
    String nome;
    Double quantidade;
    String solicitar;

    public void solicitar(String nome, double quantidade, String solicitar){
        this.nome = nome;
        this.quantidade = quantidade;
        this.solicitar = solicitar;
    }
     public String getNome(){
        return nome;
     }
     public Double getQuantidade(){
        return quantidade;
     }
     public String getSolicitar(){
        return solicitar;
     }


        }
    }

