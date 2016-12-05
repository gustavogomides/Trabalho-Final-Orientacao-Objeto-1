package Modelo;

import java.io.Serializable;
import java.util.Date;

public class Reserva implements Serializable {

    private Date aEntrada;
    private Date aSaida;
    private double aDesconto;
    private Quarto quarto;
    private Cliente cliente;
    private int aCodigo;
    private double aValorTotal;
    private double aPreco;
    private boolean aSituacao;
    private boolean aCancelada;
    private double aValorPago;

    public Reserva() {

    }

    public Reserva(Date pEntrada, Date pSaida, double pDesconto, int pCodigo,
            Quarto pQuarto, Cliente pCliente, double pValorTotal, double pPreco,
            boolean pSitucao, boolean pCancelada, double pValorPago) {
        setEntrada(pEntrada);
        setSaida(pSaida);
        setDesconto(pDesconto);
        setCodigo(pCodigo);
        setQuarto(pQuarto);
        setCliente(pCliente);
        setValorTotal(pValorTotal);
        setPreco(pPreco);
        setSituacao(pSitucao);
        setCancelada(pCancelada);
        setValorPago(pValorPago);
    }

    public void setValorPago(double pValorPago) {
        aValorPago = pValorPago;
    }

    public void setCancelada(boolean pCancela) {
        aCancelada = pCancela;
    }

    public void setSituacao(boolean pSituacao) {
        aSituacao = pSituacao;
    }

    public void setPreco(double pPreco) {
        aPreco = pPreco;
    }

    public void setValorTotal(double pValorTotal) {
        aValorTotal = pValorTotal;
    }

    public void setEntrada(Date pEntrada) {
        aEntrada = pEntrada;
    }

    public void setSaida(Date pSaida) {
        aSaida = pSaida;
    }

    public void setDesconto(double pDesconto) {
        aDesconto = pDesconto;
    }

    public void setQuarto(Quarto pQuarto) {
        quarto = pQuarto;
    }

    public void setCliente(Cliente pCliente) {
        cliente = pCliente;
    }

    public void setCodigo(int pCodigo) {
        aCodigo = pCodigo;
    }

    public double getPreco() {
        return aPreco;
    }

    public Date getEntrada() {
        return aEntrada;
    }

    public Date getSaida() {
        return aSaida;
    }

    public double getValorTotal() {
        return aValorTotal;
    }

    public double getDesconto() {
        return aDesconto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public int getCodigo() {
        return aCodigo;
    }

    public boolean getSituacao() {
        return aSituacao;
    }

    public boolean getCancelada() {
        return aCancelada;
    }

    public double getValorPago() {
        return aValorPago;
    }
}
