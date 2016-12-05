package Relatorio;

import Modelo.Cliente;
import Modelo.Quarto;
import java.util.Date;

public class modeloRR {

    private String entrada;
    private String saida;
    private String desconto;
    //private Quarto quarto;
    //private Cliente cliente;
    private String codigo;
    private String valorTotal;
    private String preco;
    private String situacao;
    private String cancelada;
    private String valorPago;
    private String nome;
    private String cpf;
    private String quarto;

    public modeloRR(String nome, String cpf, String quarto, String valorTotal,
            String desconto, String entrada, String saida) {
        this.nome = nome;
        this.cpf = cpf;
        this.quarto = quarto;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.entrada = entrada;
        this.saida = saida;
        /*this.situacao = situacao;
        this.entrada = entrada;
         this.saida = saida;
         this.desconto = desconto;
         this.codigo = codigo;
         this.valorTotal = valorTotal;
         this.preco = preco;         
         this.cancelada = cancelada;
         this.valorPago = valorPago; */
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setCancelada(String cancelada) {
        this.cancelada = cancelada;
    }

    public void setValorPago(String valorPago) {
        this.valorPago = valorPago;
    }

    public String getEntrada() {
        return entrada;
    }

    public String getSaida() {
        return saida;
    }

    public String getDesconto() {
        return desconto;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public String getPreco() {
        return preco;
    }

    public String getSituacao() {
        return situacao;
    }

    public String getCancelada() {
        return cancelada;
    }

    public String getValorPago() {
        return valorPago;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getQuarto() {
        return quarto;
    }

}
