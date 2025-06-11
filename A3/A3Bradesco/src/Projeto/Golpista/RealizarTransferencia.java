package Projeto.Golpista;
import java.util.Date;

public class RealizarTransferencia {

    String nomeDestinatario;
    String nomeBanco;
    Double numeroBanco;
    Double valor;
    Date dataTransferencia;

    public RealizarTransferencia(String nomeDestinatario, String nomeBanco, double numeroBanco, double valor, Date dataTransferencia){
        this.nomeDestinatario = nomeDestinatario;
        this.nomeBanco = nomeBanco;
        this.numeroBanco = numeroBanco;
        this.valor = valor;
        this.dataTransferencia = dataTransferencia;
    }
    //GET OUT
    public String getNomeDestinario(){
       return nomeDestinatario;
    }
   public String getNomeBanco(){
    return nomeBanco;
   }
   public double getNumeroBanco(){
    return numeroBanco;
   }
   public double getValor(){
    return valor;
   }
   public Date getDataTransferencia(){
    return dataTransferencia;
   }

}
