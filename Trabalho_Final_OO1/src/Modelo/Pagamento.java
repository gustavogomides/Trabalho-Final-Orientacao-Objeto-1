package Modelo;

import java.io.Serializable;

public class Pagamento implements Serializable {

    private double aValorTotal;
    private double aValorPago;
    private Reserva reserva;
    private boolean aSituacao;

    public Pagamento(double pValor, Reserva pReserva, boolean pSituacao, double pValorPago) {
        setValorTotal(pValor);
        setReserva(pReserva);
        setSituacao(pSituacao);
        setValorPago(pValorPago);
    }

    public void setSituacao(boolean pSituacao) {
        aSituacao = pSituacao;
    }

    public void setValorTotal(double pValorTotal) {
        aValorTotal = pValorTotal;
    }

    public void setValorPago(double pValorPago) {
        aValorPago = pValorPago;
    }

    public void setReserva(Reserva pReserva) {
        reserva = pReserva;
    }

    public double getValorTotal() {
        return aValorTotal;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public boolean getSituacao() {
        return aSituacao;
    }

    public double getValorPago() {
        return aValorPago;
    }
}
